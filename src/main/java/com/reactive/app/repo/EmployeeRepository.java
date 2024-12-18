package com.reactive.app.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.reactive.app.dto.Employee;

import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer>{

}
