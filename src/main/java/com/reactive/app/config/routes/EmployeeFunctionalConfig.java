package com.reactive.app.config.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.app.dto.Employee;
import com.reactive.app.repo.EmployeeRepository;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyExtractors.toMono;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class EmployeeFunctionalConfig {
	
	@Autowired
	EmployeeRepository repo;
	

	@Bean
	RouterFunction<ServerResponse> getEmployeeByIdRoute() {
		return route(GET("/employees/{id}"),				
				req -> ok().body(repo.findById(Integer.valueOf(req.pathVariable("id"))), Employee.class));
	}
	
	@Bean
	RouterFunction<ServerResponse> getAllEmployeeRoute() {
		return route(GET("/employees"),				
				req -> ok().body(repo.findAll(), Employee.class));
	}
	
	
	@Bean
	RouterFunction<ServerResponse> updateEmployeeRoute() {
		return route(POST("/employees/update"),				
				req -> req.body(toMono(Employee.class))
				.doOnNext(repo::save)
				.then(ok().build()));
	}

}
