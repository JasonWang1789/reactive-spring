package com.jwang.reactive.reactivemongodemo.service;

import com.jwang.reactive.reactivemongodemo.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmployeeService {

    Flux<Employee> findAll();

    Mono<Employee> findById(String empId);

    Flux<Employee> saveAll(List<Employee> employees);

}
