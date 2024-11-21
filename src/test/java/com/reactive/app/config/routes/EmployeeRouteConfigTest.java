package com.reactive.app.config.routes;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.mock.mockito.MockBean ;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


import com.reactive.app.dto.Employee;
import com.reactive.app.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.assertj.core.util.Arrays;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = EmployeeRouteConfigTest.class) 
public class EmployeeRouteConfigTest {
	
	
	@Autowired 
	EmployeeFunctionalConfig config; 	
	
	@Mock 
	@Qualifier
	EmployeeRepository mockRemployeeRepo;

	@Test
	void givenEmployeeId_whenGetEmployeeById_thenCorrectEmployee()
	{
		WebTestClient client = WebTestClient.bindToRouterFunction(config.getEmployeeByIdRoute())
				.build();
		
		Employee employee = new Employee("1", "Nitin Gupta");
		
		given(mockRemployeeRepo.findById(1))
		.willReturn(Mono.just(employee));
		
		client.get()
		.uri("/employees/1")
		.exchange()
		.expectStatus()
		.isOk()
		.expectBody(Employee.class)
		.isEqualTo(employee);
	}
	
	@Test
	void whenGetAllEmployee_thenCorrectEmployee()
	{
		WebTestClient client = WebTestClient.bindToRouterFunction(config.getAllEmployeeRoute())
				.build();
	
		List<Employee> employees = List.of(new Employee("1", "Nitin Gupta"), 
				new Employee("1", "Ravi Garg"));
		
		Flux<Employee> fluxEmployee=Flux.fromIterable(employees);
		
		given(mockRemployeeRepo.findAll())
		.willReturn(fluxEmployee);
		
		client.get()
		.uri("/employees")
		.exchange()
		.expectStatus()
		.isOk()
		.expectBodyList(Employee.class)
		.isEqualTo(employees);
	}
	
	@Test
	void whenUpdateEmployee_thenEmployeeUpdated()
	{
		WebTestClient client = WebTestClient.bindToRouterFunction(config.updateEmployeeRoute())
				.build();	
		
		Employee employee = new Employee("1", "Nitin Updated ");
		
		client.post()
		.uri("/employees/update")
		.body(Mono.just(employee), Employee.class)
		.exchange()
		.expectStatus()
		.isOk();
		
		verify(mockRemployeeRepo).save(employee);
	}
	
}
