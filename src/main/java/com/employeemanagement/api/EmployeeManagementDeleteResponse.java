package com.employeemanagement.api;

import com.employeemanagement.models.Employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeManagementDeleteResponse {

    private String status;
    private String data;
    private String message;
}
