package org.viapivov.loader;

public class BuildInfo {

	private final String name;
	private final String argument;

	public BuildInfo(String name, String jsonString) {
		this.name = name;
		this.argument = jsonString;
	}

	public String getName() {
		return name;
	}

	public String getArgument() {
		return argument;
	}

}
