package com.reactive.app.foo;

public class Foo {

	private String formattedName;
	private Integer id;
	private Integer qty;

	public String getFormattedName() {
		return formattedName;
	}

	public void setFormattedName(String processedName) {
		formattedName=processedName;
	}

	public Integer getId() {
		return id;
	}

	public Integer getQuantity() {
		return qty;
	}

	public void setQuantity(int qty) {
		this.qty=qty;		
	}
}
