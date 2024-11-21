package com.reactive.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class EmployeeWebSecurityConfig {
	
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		
		http.csrf().disable()
		.authorizeExchange()
		.pathMatchers(HttpMethod.POST, "/employee/update")
		.hasRole("ADMIN")
		.pathMatchers("/**")
		.permitAll();
		return http.build();
	}
}
