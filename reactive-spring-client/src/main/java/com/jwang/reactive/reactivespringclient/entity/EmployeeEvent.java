package com.jwang.reactive.reactivespringclient.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEvent {

  private Employee employee;
  private Date date;

}
