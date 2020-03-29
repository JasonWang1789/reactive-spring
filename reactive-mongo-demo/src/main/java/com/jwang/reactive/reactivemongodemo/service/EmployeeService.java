package com.jwang.reactive.reactivemongodemo.service;

import com.jwang.reactive.reactivemongodemo.entity.Employee;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

  Flux<Employee> findAll();

  Mono<Employee> findById(String empId);

  Flux<Employee> saveAll(List<Employee> employees);

}
