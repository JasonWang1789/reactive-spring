package com.jwang.reactive.reactivespringclient.client;

import com.jwang.reactive.reactivespringclient.entity.Employee;
import com.jwang.reactive.reactivespringclient.entity.EmployeeEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EmployeeClient {

    @Bean
    WebClient webClient() {
        return WebClient.create("http://localhost:8082/api/v1/employee");
    }

    @Bean
    CommandLineRunner commandLineRunner(WebClient webClient) {
        return args -> webClient.get()
                .uri("/all")
                .retrieve()
                .bodyToFlux(Employee.class)
                .filter(employee -> employee.getName().equalsIgnoreCase("Peter"))
                .flatMap(employee -> webClient.get()
                        .uri("/{id}/event", employee.getId())
                        .retrieve()
                        .bodyToFlux(EmployeeEvent.class))
                .subscribe(System.out::println);
    }

}
