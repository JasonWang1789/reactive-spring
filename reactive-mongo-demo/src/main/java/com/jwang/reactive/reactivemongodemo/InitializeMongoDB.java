package com.jwang.reactive.reactivemongodemo;

import com.jwang.reactive.reactivemongodemo.entity.Employee;
import com.jwang.reactive.reactivemongodemo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitializeMongoDB {

    @Bean
    CommandLineRunner employees(EmployeeRepository employeeRepository) {
        return args -> employeeRepository
                .deleteAll()
                .subscribe(null, null,
                        () -> employeeRepository.saveAll(getEmployees()).subscribe(System.out::println));
    }

    private Iterable<Employee> getEmployees() {
        return List.of(
                new Employee("1", "Peter", 1000L),
                new Employee("2", "Sara", 2000L),
                new Employee("3", "Joe", 3000L)
        );
    }

}
