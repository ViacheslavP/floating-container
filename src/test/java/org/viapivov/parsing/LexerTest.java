package org.viapivov.parsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import org.viapivov.antlr4.ContainerJsonLexer;

public class LexerTest {

	@Test
	void mustTokenize() {
		String str = "{}";
		List<Token> tokens = tokenize(str);
		assertEquals(List.of("{", "}", "<EOF>"), tokens.stream().map(Token::getText).collect(Collectors.toList()));
		assertEquals(List.of(ContainerJsonLexer.T__0, ContainerJsonLexer.T__2, -1),
				tokens.stream().map(Token::getType).collect(Collectors.toList()));

	}

	@Test
	void mustTokenizeSingleEntryWithClassName() {
		String str = "{\"class\":{\"className\": \"clazz\"}}";
		List<Token> tokens = tokenize(str);
		assertEquals(List.of("{", "\"class\"", ":", "{", "\"className\"", ":", "\"clazz\"", "}", "}", "<EOF>"), tokens
				.stream().map(Token::getText).collect(Collectors.toList()));
		assertEquals(
				List.of(1, ContainerJsonLexer.STRING, 4, 1, ContainerJsonLexer.CLASS_NAME, 4,
						ContainerJsonLexer.STRING, 3, 3,
						-1),
				tokens
						.stream().map(Token::getType).collect(Collectors.toList()));
	}

	private static List<Token> tokenize(String str) {
		return TestUtil.getStream(str).getTokens();
	}
}
