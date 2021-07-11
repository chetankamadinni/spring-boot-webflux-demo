package io.spring.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.webflux.dao.EmployeeRepo;
import io.spring.webflux.dto.Employee;
import reactor.core.publisher.Flux;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getEmployees() {
		long start = System.currentTimeMillis();
		List<Employee> employees = employeeRepo.getEmployees();
		long end = System.currentTimeMillis();
		System.out.println("Time taken for processing is : " + (end - start));
		return employees;
	}
	
	public Flux<Employee> getEmployeeStream() {
		long start = System.currentTimeMillis();
		Flux<Employee> employees = employeeRepo.getEmployeeStream();
		long end = System.currentTimeMillis();
		System.out.println("Time taken for processing is : " + (end - start));
		return employees;
	}
}
