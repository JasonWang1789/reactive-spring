package com.jwang.reactive.reactivemongodemo.service.impl;

import com.jwang.reactive.reactivemongodemo.entity.Employee;
import com.jwang.reactive.reactivemongodemo.repository.EmployeeRepository;
import com.jwang.reactive.reactivemongodemo.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Override
  public Flux<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Mono<Employee> findById(String id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Flux<Employee> saveAll(List<Employee> employees) {
    return employeeRepository.saveAll(employees);
  }

}
