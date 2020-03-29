package com.jwang.reactive.reactivemongodemo.repository;

import com.jwang.reactive.reactivemongodemo.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {

}
