package com.eCommerceProject.core.concretes;

public class Result {

    private String message;
    private boolean success;

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
