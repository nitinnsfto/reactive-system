package com.reactive.app.foo;

import java.util.concurrent.ThreadLocalRandom;

public class FooNameHelper {

	public static Foo concatFooName(Foo foo) {
		int random = ThreadLocalRandom.current().nextInt(0,80);
		
		String processedName = (random != 0) ? foo.getFormattedName(): foo.getFormattedName() + "-niti";
		foo.setFormattedName(processedName);
		return foo;

	}
	
	public static Foo subStringFooName(Foo foo) {
		int random = ThreadLocalRandom.current().nextInt(0,80);
		
		String processedName = (random != 0) ? foo.getFormattedName().substring(0,5): foo.getFormattedName().substring(10,15);
		foo.setFormattedName(processedName);
		return foo;
	}

}
