package org.viapivov;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.viapivov.antlr4.ContainerJsonLexer;
import org.viapivov.antlr4.ContainerJsonParser;
import org.viapivov.listener.LazyLoaderVisitor;
import org.viapivov.loader.LazyLoader;
import org.viapivov.loader.Loader;

public class LoaderBuilder {

	public static Loader build(LoadMode mode, InputStream is) throws IOException {
		switch (mode) {
			case LAZY:
				ParseTree tree = parseStream(is);
				LazyLoaderVisitor visitor = new LazyLoaderVisitor().visit(tree);
				return new LazyLoader(visitor.getBuildInfo(), visitor.getAliases());

			default:
				throw new LoadMode.ModeDoesNotExistException("Unexpected mode found: " + String.valueOf(mode));

		}
	}

	protected static ParseTree parseStream(InputStream is) throws IOException {
		ContainerJsonLexer lexer = new ContainerJsonLexer(CharStreams.fromStream(is, Charset.forName("utf-8")));
		CommonTokenStream stream = new CommonTokenStream(lexer);
		return new ContainerJsonParser(stream).classEntries();
	}
}
