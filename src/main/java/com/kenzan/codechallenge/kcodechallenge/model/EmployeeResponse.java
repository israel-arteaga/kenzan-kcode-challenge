package com.kenzan.codechallenge.kcodechallenge.model;

public class EmployeeResponse {
    private boolean success;
    private String message;

    public EmployeeResponse() {
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
