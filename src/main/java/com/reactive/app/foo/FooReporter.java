package com.reactive.app.foo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooReporter {

	private static Logger LOGGER=LoggerFactory.getLogger(FooReporter.class);

	public static Foo reportResults(Foo foo) {
		return reportResults(foo, "default");
	}
	
	public static Foo reportResults(Foo foo, String approach) {
		if (foo.getId()==null)
		 {
			throw new IllegalArgumentException("Null id is not valid");
		 }
		LOGGER.info("" + approach,foo.getId(),foo.getFormattedName(), foo.getQuantity());
		return foo;
	}

}
