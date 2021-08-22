package com.employeemanagement.api;

import com.employeemanagement.models.Employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeManagementResponse {

    private String status;
    private Employee data;
    private String message;
}
