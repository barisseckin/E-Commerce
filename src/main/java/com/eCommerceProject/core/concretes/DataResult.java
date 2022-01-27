package com.eCommerceProject.core.concretes;


public class DataResult<T> extends Result{

    private T data;

    public DataResult(String message, boolean success, T data) {
        super(message, success);
        this.data = data;
    }

    public DataResult(String message) {
        super(message);
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(T data, String message) {
        super(message);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

}
