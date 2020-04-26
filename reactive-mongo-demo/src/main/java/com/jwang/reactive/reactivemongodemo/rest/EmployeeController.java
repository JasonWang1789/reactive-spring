package com.jwang.reactive.reactivemongodemo.rest;

import com.jwang.reactive.reactivemongodemo.entity.Employee;
import com.jwang.reactive.reactivemongodemo.entity.EmployeeEvent;
import com.jwang.reactive.reactivemongodemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public Flux<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> getId(@PathVariable("id") final String empId) {
        return employeeService.findById(empId);
    }

    @GetMapping(value = "/{id}/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getEventById(@PathVariable("id") String id) {
        return employeeService.findById(id)
                .flatMapMany(employee -> {
                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                            Stream.generate(() -> new EmployeeEvent(employee, new Date()))
                    );
                    return Flux.zip(interval, employeeEventFlux)
                            .log("Datetime: " + LocalDateTime.now().toString())
                            .map(Tuple2::getT2);
                });
    }

    @PostMapping
    public Flux<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveAll(employees);
    }

}
