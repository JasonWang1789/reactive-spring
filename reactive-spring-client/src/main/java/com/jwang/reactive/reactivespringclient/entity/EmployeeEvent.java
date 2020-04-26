package com.jwang.reactive.reactivespringclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEvent {

    private Employee employee;
    private Date date;

}
