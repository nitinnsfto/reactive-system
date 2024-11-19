package com.reactive.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.app.dto.Employee;
import com.reactive.app.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/{id}")
	private Mono<Employee> getEmployeeById(@PathVariable Integer id)
	 {
		return employeeRepository.findById(id);
	 }

	@GetMapping("/{id}")
	private Flux<Employee> getAllEmployees(@PathVariable String id)
	 {
		return employeeRepository.findAll();
	 }

}
