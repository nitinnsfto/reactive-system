package com.reactive.app.foo;

public class FooQuantityHelper {

	public static Foo divideFooQuantity(Foo foo) {
		int qty = (int) Math.round(5.0 / foo.getQuantity());
		
		foo.setQuantity(qty);
		
		return foo;		
	}
	
}
