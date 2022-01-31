package com.eCommerceProject.core.concretes;

public class ErrorResult extends Result{

    public ErrorResult(String message, boolean success) {
        super(message, false);
    }

    public ErrorResult(String message) {
        super(message);
    }

}
