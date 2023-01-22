package com.asyncapi.example.generateasyncapipojos.internal.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class User {

    private String userId;
    private String userName;
    private Boolean isUserManager;
    private LocalDate dateAdded;
    private List<User> employees;

    public User(String userId, String userName, Boolean isUserManager, LocalDate dateAdded, List<User> employees) {
        this.userId = userId;
        this.userName = userName;
        this.isUserManager = isUserManager;
        this.dateAdded = dateAdded;
        this.employees = employees;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @JsonProperty("isUserManager")
    public Boolean getUserManager() {
        return isUserManager;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public List<User> getEmployees() {
        return employees;
    }
}
