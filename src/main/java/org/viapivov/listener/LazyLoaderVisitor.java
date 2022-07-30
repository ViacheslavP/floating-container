package org.viapivov.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;
import org.viapivov.antlr4.ContainerJsonBaseVisitor;
import org.viapivov.antlr4.ContainerJsonParser;
import org.viapivov.antlr4.ContainerJsonParser.ClassEntriesContext;
import org.viapivov.antlr4.ContainerJsonParser.ClassEntryContext;
import org.viapivov.loader.BuildInfo;

import com.google.gson.Gson;

public class LazyLoaderVisitor extends ContainerJsonBaseVisitor<LazyLoaderVisitor> {

	public static final Gson GSON = new Gson();

	private final Map<String, List<BuildInfo>> buildInfo;
	private final Map<String, String> aliases;

	public LazyLoaderVisitor() {
		this.aliases = new HashMap<>();
		this.buildInfo = new HashMap<>();
	}

	public Map<String, List<BuildInfo>> getBuildInfo() {
		return buildInfo;
	}

	public Map<String, String> getAliases() {
		return aliases;
	}

	@Override
	public LazyLoaderVisitor visitClassEntries(ClassEntriesContext ctx) {
		ctx.classEntry().stream().map(this::visitClassEntry).allMatch(this::equals);
		return this;
	}

	@Override
	public LazyLoaderVisitor visitClassEntry(ClassEntryContext ctx) {
		String alias = getText(ctx.alias());
		aliases.put(alias, getText(ctx.className().name()));
		if (ctx.jsonObject() != null) {
			List<BuildInfo> list = ctx.jsonObject().keyValuePair().stream().map(kv -> {
				return new BuildInfo(getText(kv.STRING(0)), extractArgument(kv));
			}).collect(Collectors.toList());
			buildInfo.put(alias, list);
		}
		return this;
	}

	private static String extractArgument(ContainerJsonParser.KeyValuePairContext ctx) {
		if (ctx.NUMBER() != null) {
			return getText(ctx.NUMBER());
		}
		if (ctx.STRING(1) != null) {
			return getText(ctx.STRING(1));
		}
		if (ctx.BOOL() != null) {
			return getText(ctx.BOOL());
		}
		if (ctx.jsonObject() != null) {
			return "{" + ctx.jsonObject().getText() + "}";
		}
		throw new ListenerException("[GRAMMAR] text " + ctx.getText() + " has not been parsed correctly");
	}

	private static String getText(ParseTree ctx) {
		return ctx.getText().replaceAll("(?:^[\"']|[\"']$)", "");
	}

}
