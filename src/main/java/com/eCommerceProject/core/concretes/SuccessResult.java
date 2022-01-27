package com.eCommerceProject.core.concretes;

public class SuccessResult extends Result{

    public SuccessResult(String message, boolean success) {
        super(message, true);
    }

    public SuccessResult(String message) {
        super(message);
    }


}
