package org.viapivov;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.viapivov.listener.LazyLoaderVisitor;
import org.viapivov.loader.LazyLoader;
import org.viapivov.loader.Loader;

public class LoaderBuilderTest extends LoaderBuilder {

	@ParameterizedTest
	@ValueSource(strings = "simpleLoader.json")
	void testFactoryCreation(String str) throws IOException {
		ClassLoader classLoader = LoaderBuilderTest.class.getClassLoader();
		Loader loader = LoaderBuilder.build(LoadMode.LAZY,
				classLoader.getResourceAsStream(str));
		assertNotNull(loader);
		assertTrue(loader instanceof LazyLoader);

		LazyLoaderVisitor visitor = new LazyLoaderVisitor()
				.visit(parseStream(classLoader.getResourceAsStream(str)));

		List<Object> classAndAliases = new ArrayList<>();
		assertDoesNotThrow(() -> visitor.getAliases().forEach((alias, className) -> {
			Class<?> clazz = null;
			try {
				clazz = classLoader.loadClass(className);
			} catch (ClassNotFoundException e) {
				fail(str, e);
			}
			classAndAliases.add(loader.load(clazz, alias));
		}));

		List<Object> onlyAliases = new ArrayList<>();
		assertDoesNotThrow(() -> visitor.getAliases().forEach((alias, className) -> {

			onlyAliases.add(loader.load(alias));
		}));

		assertEquals(onlyAliases, classAndAliases);

		assertDoesNotThrow(() -> visitor.getAliases().forEach((alias, className) -> {
			Class<?> clazz = null;
			try {
				clazz = classLoader.loadClass(className);
			} catch (ClassNotFoundException e) {
				fail(str, e);
			}
			assertTrue(loader.load(clazz).allMatch(obj -> classAndAliases.contains(obj)));
		}));
	}
}
