package com.employeemanagement.models;

import ch.qos.logback.classic.turbo.MDCValueLevelPair;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResponseType {

    SUCCESS_STATUS("success"),
    CREATE_SUCCESS_MESSAGE("Successfully! Record has been added."),
    VIEW_ONE_SUCCESS_MESSAGE("Successfully! Record has been fetched."),
    VIEW_ALL_SUCCESS_MESSAGE("Successfully! All records has been fetched."),
    UPDATE_SUCCESS_MESSAGE("Successfully! Record has been updated."),
    DELETE_SUCCESS_MESSAGE("Successfully! Record has been deleted");

    @Getter
    private String value;

}
