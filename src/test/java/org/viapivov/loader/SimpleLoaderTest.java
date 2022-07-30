package org.viapivov.loader;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SimpleLoaderTest {

	@Test
	void testNoConstructorLoad() {
		Loader loader = new LazyLoader(Map.of(), Map.of());
		NoConstructorClass test = loader.load(NoConstructorClass.class, "");
		assertNotNull(test);
	}

	@Test
	void testOneArgConstructorLoad() {
		BuildInfo buildInfo = new BuildInfo("useless field", "{\"name\":\"bar\"}");
		Loader loader = new LazyLoader(Map.of("", List.of(buildInfo)),
				Map.of("", OneObjectArgConstructorClass.class.getName()));
		OneObjectArgConstructorClass test = loader.load(OneObjectArgConstructorClass.class, "");
		assertNotNull(test);
	}

	@Test
	void testStringConstructorLoad() {
		BuildInfo buildInfo = new BuildInfo("useless field", "one");
		Loader loader = new LazyLoader(Map.of("", List.of(buildInfo)),
				Map.of("", OneObjectArgConstructorClass.class.getName()));
		OneObjectArgConstructorClass test = loader.load(OneObjectArgConstructorClass.class, "");
		assertNotNull(test);
	}

	@Test
	void testAliasConstructorLoad() {
		BuildInfo buildInfo = new BuildInfo("useless field", "one");
		Loader loader = new LazyLoader(Map.of("1", List.of(buildInfo), "0", List.of()),
				Map.of("1", OneObjectArgConstructorClass.class.getName(), "0", NoConstructorClass.class.getName()));
		OneObjectArgConstructorClass test = loader.load(OneObjectArgConstructorClass.class, "1");
		assertNotNull(test);
	}
}
