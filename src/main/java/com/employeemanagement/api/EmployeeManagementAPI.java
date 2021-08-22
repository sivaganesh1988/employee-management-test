package com.employeemanagement.api;

import com.employeemanagement.models.Employee;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;

import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class EmployeeManagementAPI {

    private EnvironmentVariables environmentVariables;

    public Response response;
    public String responseAsString;
    public String webserviceEndpoint;



    @Step("Siva requests to create a new employee with valid {0},{1},{2} and {3}")
    public void createNewEmployee(Employee employee) {
        webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webservice.create.endpoint");

        //String webserviceEndpoint = "http://dummy.restapiexample.com/api/v1/create";
        response = SerenityRest.given()
                    .body(employee)
                .post(webserviceEndpoint);
    }

    @Step
    public void getEmployeeDetails(Integer id) {

        webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webservice.getOne.endpoint");
        //String webserviceEndpoint = "http://dummy.restapiexample.com/api/v1/employee/{employeeId}";
        response = SerenityRest.given()
                .pathParam("employeeId",id)
                .get(webserviceEndpoint);
    }

    public void getAllEmployeeDetails() {
        webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webservice.getAll.endpoint");
        //String webserviceEndpoint = "http://dummy.restapiexample.com/api/v1/employees";
        response = SerenityRest.given()
                .get(webserviceEndpoint);
    }

    public void updateEmployeeDetails(Employee employee,Integer id) {
        webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webservice.update.endpoint");
        //String webserviceEndpoint = "http://dummy.restapiexample.com/api/v1/update/{employeeId}";
        response = SerenityRest.given()
                .pathParam("employeeId",id)
                .body(employee)
                .put(webserviceEndpoint);
    }

    public void deleteEmployee(Integer id) {

        webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webservice.delete.endpoint");
        //String webserviceEndpoint = "http://dummy.restapiexample.com/api/v1/delete/{employeeId}";
        response = SerenityRest.given()
                .pathParam("employeeId",id)
                .delete(webserviceEndpoint);
    }

}
