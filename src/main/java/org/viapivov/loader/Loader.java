package org.viapivov.loader;

import java.util.stream.Stream;

public interface Loader {

	<T> Stream<T> load(Class<T> clazz);

	<T> T load(Class<T> clazz, String alias);

	Object load(String alias);

	Object load(String alias, ClassLoader classLoader);
}
