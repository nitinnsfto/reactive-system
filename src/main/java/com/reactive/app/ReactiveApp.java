package com.reactive.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages="com.reactive.app.repo")
public class ReactiveApp {
	
	public static void main(String[]  args)
	 {
		SpringApplication.run(ReactiveApp.class, args);
	 }

}
