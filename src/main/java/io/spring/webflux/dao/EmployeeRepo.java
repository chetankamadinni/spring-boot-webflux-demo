package io.spring.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import io.spring.webflux.dto.Employee;
import reactor.core.publisher.Flux;

@Component
public class EmployeeRepo {

	public void introduceDelay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Employee> getEmployees() {
		List<Employee> employeeList = IntStream.rangeClosed(1, 10)
				.peek(i -> System.out.println("Employee " + i + " data is processing...")).peek(i -> introduceDelay())
				.mapToObj(i -> new Employee(i, "Employee : " + i)).collect(Collectors.toList());
		return employeeList;
	}

	public Flux<Employee> getEmployeeStream() {
		Flux<Employee> employeeFlux = Flux.range(1, 10).delayElements(Duration.ofSeconds(1)).doOnNext(i -> System.out.println("Employee " + i + " data is processing..."))
				.map(i -> new Employee(i, "Employee : " + i));
		return employeeFlux;
	}
}
