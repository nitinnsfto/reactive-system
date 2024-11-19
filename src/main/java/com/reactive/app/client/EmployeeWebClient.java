package com.reactive.app.client;

import org.springframework.web.reactive.function.client.WebClient;

public class EmployeeWebClient {

	public static void main(String[]  args)
	 {
		WebClient client = WebClient.create("http://localhost:8080");
	 }
	
}
