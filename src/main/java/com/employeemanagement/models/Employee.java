package com.employeemanagement.models;

import lombok.*;

@Data
@Builder(builderClassName = "EmployeeBuilder", toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    String employee_name;
    Integer employee_age;
    Integer employee_salary;
    String profile_image;

}
