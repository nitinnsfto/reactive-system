package com.reactive.app.client;

import org.springframework.web.reactive.function.client.WebClient;

import com.reactive.app.dto.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeWebClient {

	public static void main(String[]  args)
	 {
		WebClient client = WebClient.create("http://localhost:8080");
		
		Mono<Employee> employeeMono = client.get().uri("/employees/{id}", "1")
				.retrieve()
				.bodyToMono(Employee.class);
		employeeMono.subscribe(System.out::println);	

		Flux<Employee> employeeFlux = client.get().uri("/employees")
				.retrieve()
				.bodyToFlux(Employee.class);
		
		employeeFlux.subscribe(System.out::println);	
	 }
	
}
