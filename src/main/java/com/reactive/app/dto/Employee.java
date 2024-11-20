package com.reactive.app.dto;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Employee {

	@Id
    UUID id;
	
	@Getter
	@Setter
    private String name;
	Integer salary;
    
}
