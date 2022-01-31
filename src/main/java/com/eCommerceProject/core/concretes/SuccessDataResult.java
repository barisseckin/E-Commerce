package com.eCommerceProject.core.concretes;

public class SuccessDataResult<T> extends DataResult{

    public SuccessDataResult(String message, boolean success, Object data) {
        super(message, true, data);
    }

    public SuccessDataResult(String message) {
        super(message);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(T data, String message) {
        super(data, message);
    }

}
