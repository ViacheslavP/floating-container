package org.viapivov.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Container {
	private final Map<String, Object> builtObjects;

	public Container() {
		this.builtObjects = new HashMap<>();
	}

	public Object put(String alias, Object arg0) {
		builtObjects.put(alias, arg0);
		return arg0;
	}

	public <T> T get(Class<T> clazz, String alias) {
		return (T) builtObjects.get(alias);
	}

	public Object get(String alias) {
		return builtObjects.get(alias);
	}

	public <T> Collection<T> get(Class<T> clazz) {
		List<T> list = new ArrayList<>();
		for (Object obj : builtObjects.values()) {
			if (clazz.isAssignableFrom(obj.getClass())) {
				list.add((T) obj);
			}
		}
		return list;
	}
}
