package org.viapivov.loader;

public class OneObjectArgConstructorClass {
	TestObject object;

	public OneObjectArgConstructorClass(TestObject object) {
		this.object = object;
	}

	public OneObjectArgConstructorClass(String name) {
		this.object = new TestObject(name);
	}

	public OneObjectArgConstructorClass(NoConstructorClass name) {
		this.object = new TestObject("name");
	}
}
