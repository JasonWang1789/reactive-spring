package com.jwang.reactive.reactivemongodemo.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEvent {

  private Employee employee;
  private Date date;

}
