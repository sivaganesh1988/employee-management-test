package com.employeemanagement.stepdefinitions;

import com.employeemanagement.api.EmployeeManagementAPI;
import com.employeemanagement.api.EmployeeManagementDeleteResponse;
import com.employeemanagement.api.EmployeeManagementResponse;
import com.employeemanagement.models.Employee;
import com.employeemanagement.models.ResponseType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;

import java.util.function.Consumer;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;


public class EmployeeManagementStepDefinition extends EmployeeManagementAPI{

    Consumer<Description> descriptionConsumer;
    final StringBuilder descriptionReportBuilder = new StringBuilder(String.format("Assertions:%n"));

    public EmployeeManagementStepDefinition(){
       descriptionConsumer = desc -> descriptionReportBuilder.append(String.format("-- %s%n", desc));
       Assertions.setDescriptionConsumer(descriptionConsumer);
    }

    @When("Siva requests to create a new employee with data {string},{int},{int} and {string}")
    public void sivaRequestsToCreateANewEmployeeWithValidAnd(String employee_name, Integer employee_age, Integer employee_salary, String profile_image) {
        Employee employee = new Employee(employee_name,employee_age,employee_salary,profile_image);
        createNewEmployee(employee);
   
    }

    @Then("he should be able to create a new employee successfully")
    public void heShouldBeAbleToCreateANewEmployeeSuccessfully() {
        restAssuredThat(response -> response.statusCode(200));
        EmployeeManagementResponse apiResponse = lastResponse().getBody().as(EmployeeManagementResponse.class);

        assertThat(apiResponse.getStatus())
                .as("validated status. Expected : "+ResponseType.SUCCESS_STATUS.getValue()+ " Actual : "+apiResponse.getStatus())
                .isEqualTo(ResponseType.SUCCESS_STATUS.getValue());

        assertThat(apiResponse.getMessage())
                .as("validated message. Expected : "+ ResponseType.CREATE_SUCCESS_MESSAGE.getValue()+" Actual : "+apiResponse.getMessage())
                .isEqualTo(ResponseType.CREATE_SUCCESS_MESSAGE.getValue());

        Serenity.recordReportData().withTitle("Assertion Details").andContents(descriptionReportBuilder.toString());

    }

    @Then("he should not be able to create a new employee")
    public void heShouldNotBeAbleToCreateANewEmployee() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @When("Kalai requests to view an employee details with {int}")
    public void kalaiRequestsToViewAnEmployeeDetailsWith(Integer id) {
        getEmployeeDetails(id);
    }

    @Then("she should be able to view the employee details {string},{int},{int} and {string} successfully")
    public void sheShouldBeAbleToViewTheEmployeeDetailsAndSuccessfully(String name, Integer age, Integer salary, String profilePic) {

        restAssuredThat(response -> response.statusCode(200));
        EmployeeManagementResponse apiResponse = lastResponse().getBody().as(EmployeeManagementResponse.class);

        assertThat(apiResponse.getStatus())
                .as("validated status. Expected : "+ResponseType.SUCCESS_STATUS.getValue()+ " Actual : "+apiResponse.getStatus())
                .isEqualTo(ResponseType.SUCCESS_STATUS.getValue());

        assertThat(apiResponse.getMessage())
                .as("validated message. Expected : "+ ResponseType.VIEW_ONE_SUCCESS_MESSAGE.getValue()+" Actual : "+apiResponse.getMessage())
                .isEqualTo(ResponseType.VIEW_ONE_SUCCESS_MESSAGE.getValue());

        Serenity.recordReportData().withTitle("Assertion Details").andContents(descriptionReportBuilder.toString());



    }

    @When("Kalai requests to view employee details of all existing employees")
    public void kalaiRequestsToViewEmployeeDetailsOfAllExistingEmployees() {
        getAllEmployeeDetails();
    }

    @Then("she should be able to view the complete employee list with details")
    public void sheShouldBeAbleToViewTheCompleteEmployeeListWithDetails() {
        restAssuredThat(response -> response.statusCode(200));
        EmployeeManagementResponse apiResponse = lastResponse().getBody().as(EmployeeManagementResponse.class);

        assertThat(apiResponse.getStatus())
                .as("validated status. Expected : "+ResponseType.SUCCESS_STATUS.getValue()+ " Actual : "+apiResponse.getStatus())
                .isEqualTo(ResponseType.SUCCESS_STATUS.getValue());

        assertThat(apiResponse.getMessage())
                .as("validated message. Expected : "+ ResponseType.VIEW_ALL_SUCCESS_MESSAGE.getValue()+" Actual : "+apiResponse.getMessage())
                .isEqualTo(ResponseType.VIEW_ALL_SUCCESS_MESSAGE.getValue());

        Serenity.recordReportData().withTitle("Assertion Details").andContents(descriptionReportBuilder.toString());

    }

    @When("Aadhav requests to update {int} of an employee who has an {int}")
    public void aadhavRequestsToUpdateSalaryOfAnEmployeeWhoHasAnId(Integer salary,Integer id) {
        Employee employee = new Employee();
        employee.setEmployee_salary(salary);
        updateEmployeeDetails(employee,id);
    }

    @Then("he should be able to update the employee details successfully")
    public void heShouldBeAbleToUpdateTheEmployeeDetailsSuccessfully() {
        restAssuredThat(response -> response.statusCode(200));

        EmployeeManagementResponse apiResponse = lastResponse().getBody().as(EmployeeManagementResponse.class);

        assertThat(apiResponse.getStatus())
                .as("validated status. Expected : "+ResponseType.SUCCESS_STATUS.getValue()+ " Actual : "+apiResponse.getStatus())
                .isEqualTo(ResponseType.SUCCESS_STATUS.getValue());

        assertThat(apiResponse.getMessage())
                .as("validated message. Expected : "+ ResponseType.UPDATE_SUCCESS_MESSAGE.getValue()+" Actual : "+apiResponse.getMessage())
                .isEqualTo(ResponseType.UPDATE_SUCCESS_MESSAGE.getValue());

        Serenity.recordReportData().withTitle("Assertion Details").andContents(descriptionReportBuilder.toString());

    }

    @When("Siva requests to delete an employee with {int}")
    public void sivaRequestsToDeleteAnEmployeeWithId(Integer id) {
        deleteEmployee(id);
    }

    @Then("he should be able to delete the employee successfully")
    public void heShouldBeAbleToDeleteTheEmployeeSuccessfully() {

        restAssuredThat(response -> response.statusCode(200));

        EmployeeManagementDeleteResponse apiResponse = lastResponse().getBody().as(EmployeeManagementDeleteResponse.class);

        assertThat(apiResponse.getStatus())
                .as("validated status. Expected : "+ResponseType.SUCCESS_STATUS.getValue()+ " Actual : "+apiResponse.getStatus())
                .isEqualTo(ResponseType.SUCCESS_STATUS.getValue());

        assertThat(apiResponse.getMessage())
                .as("validated message. Expected : "+ ResponseType.DELETE_SUCCESS_MESSAGE.getValue()+" Actual : "+apiResponse.getMessage())
                .isEqualTo(ResponseType.DELETE_SUCCESS_MESSAGE.getValue());

        Serenity.recordReportData().withTitle("Assertion Details").andContents(descriptionReportBuilder.toString());

    }

    @Then("he should be presented with an error")
    public void heShouldBePresentedWithAnError() {
        restAssuredThat(response -> response.statusCode(404));
    }

}

