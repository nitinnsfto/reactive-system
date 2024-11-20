package com.reactive.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/{id}")
	private Mono<Employee> getEmployeeById(@PathVariable Integer id)
	 {
		return employeeRepository.findById(id);
	 }

	@GetMapping
	private Flux<Employee> getAllEmployees()
	 {
		return employeeRepository.findAll();
	 }

	@GetMapping("/save/{name}")
	private Mono<Employee> saveEmployee(@PathVariable String name)
	 {
		Employee employee = new Employee();
		//employee.setName(name);
		return employeeRepository.save(employee);
	 }
}
