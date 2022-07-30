package org.viapivov.parsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;
import org.viapivov.antlr4.ContainerJsonBaseListener;
import org.viapivov.antlr4.ContainerJsonParser;
import org.viapivov.antlr4.ContainerJsonParser.ClassNameContext;

public class ParserTest {
	@Test
	void mustParseAlias() {
		String str = "{'class':{'className':'clazz'}}";
		ContainerJsonParser parser = new ContainerJsonParser(TestUtil.getStream(str));
		parser.addErrorListener(new ErrorListener());

		AtomicInteger classNames = new AtomicInteger(0);
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new ContainerJsonBaseListener() {
			@Override
			public void enterClassName(ClassNameContext ctx) {
				classNames.incrementAndGet();
			}
		}, parser.classEntries());
		assertEquals(1, classNames.get());
	}
}
