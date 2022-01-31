package com.eCommerceProject.core.concretes;

public class ErrorDataResult<T> extends DataResult{

    public ErrorDataResult(String message, boolean success, Object data) {
        super(message, false, data);
    }

    public ErrorDataResult(String message) {
        super(message);
    }

}
