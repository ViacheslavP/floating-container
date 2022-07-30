package org.viapivov.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Stream;

import org.viapivov.container.Container;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class LazyLoader implements Loader {

	private static final Gson gson = new GsonBuilder().setLenient().create();

	private final Container container;

	private final Map<String, List<BuildInfo>> buildInfo;
	private final Map<String, String> aliases;

	public LazyLoader(Map<String, List<BuildInfo>> buildInfo,
			Map<String, String> aliases) {
		this.container = new Container();
		this.buildInfo = buildInfo;
		this.aliases = aliases;
	}

	@Override
	public <S> S load(Class<S> clazz, String alias) {
		return Optional.ofNullable(container.get(clazz, alias))
				.orElseGet(() -> {
					S result = construct(clazz, alias);
					container.put(alias, result);
					return result;
				});
	}

	@Override
	public <T> Stream<T> load(Class<T> clazz) {
		String className = clazz.getName();
		return this.aliases.entrySet().stream().filter(e -> e.getValue().equals(className))
				.map(Entry::getKey)
				.map(alias -> load(clazz, alias));
	}

	@Override
	public Object load(String alias) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		return load(alias, classLoader);
	}

	@Override
	public Object load(String alias, ClassLoader classLoader) {
		Class<?> clazz;
		try {
			clazz = classLoader.loadClass(aliases.get(alias));
		} catch (ClassNotFoundException e) {
			throw new LoadInfoException(e);
		}
		return load(clazz, alias);
	}

	@SuppressWarnings("unchecked")
	private <S> S construct(Class<S> clazz, String alias) {
		for (Constructor<?> constructor : clazz.getConstructors()) {
			if (constructor.trySetAccessible()) {
				constructor.setAccessible(true);
			} else {
				continue;
			}
			try {
				return (S) build(alias, constructor);
			} catch (LoadInfoException lie) {
				continue;
			} catch (Exception e) {
				throw new RuntimeException("[INTERNAL]: Invocation exception", e);
			}
		}
		throw new LoadInfoException("No suitable constructor found");
	}

	private Object build(String alias, Constructor<?> constructor) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?>[] params = constructor.getParameterTypes();
		Object[] instances = new Object[params.length];
		for (int i = 0; i < params.length; i++) {
			instances[i] = container.get(alias);
			if (instances[i] == null) {
				List<BuildInfo> list = buildInfo.getOrDefault(alias, List.of());
				instances[i] = parseParam(params[i], list).orElseThrow(() -> new LoadInfoException());
			}
		}
		return constructor.newInstance(instances);
	}

	private <T> Optional<T> parseParam(Class<T> paramClazz, List<BuildInfo> list) {
		for (BuildInfo info : list) {
			if (aliases.containsKey(info.getArgument())) {
				try {
					Class<?> clazz = this.getClass().getClassLoader().loadClass(aliases.get(info.getArgument()));
					if (paramClazz.isAssignableFrom(clazz)) {
						return Optional.of(load(paramClazz, info.getArgument()));
					}
				} catch (Exception e) {
					// do nothing
				}
			}
			if (paramClazz.getName().equals("java.util.String")) {
				return Optional.of(paramClazz.cast(info.getArgument()));
			}
			try {
				T result = gson.fromJson(info.getArgument(), paramClazz);
				return Optional.of(result);
			} catch (JsonSyntaxException e) {
				continue;
			}
		}
		return Optional.empty();
	}
}
