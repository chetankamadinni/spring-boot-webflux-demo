package io.spring.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.webflux.dto.Employee;
import io.spring.webflux.service.EmployeeService;
import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, path = "/employees/stream")
	public Flux<Employee> getEmployeeStream() {
		return employeeService.getEmployeeStream();
	}
}
