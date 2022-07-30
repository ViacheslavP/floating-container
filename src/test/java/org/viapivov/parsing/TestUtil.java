package org.viapivov.parsing;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.viapivov.antlr4.ContainerJsonLexer;

public class TestUtil {

	public static CommonTokenStream getStream(String str) {
		ContainerJsonLexer lexer = new ContainerJsonLexer(CharStreams.fromString(str));
		lexer.addErrorListener(new ErrorListener());
		CommonTokenStream stream = new CommonTokenStream(lexer);
		stream.fill();
		return stream;
	}
}
