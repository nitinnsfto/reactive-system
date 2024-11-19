package com.reactive.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveApp {
	
	public static void main(String[]  args)
	 {
		SpringApplication.run(ReactiveApp.class, args);
	 }

}
