package com.boot.common.model;

public class ResponseBean<T> {
    private String code;
    private String message;
    private T entry;

    public ResponseBean() {

    }

    public ResponseBean(String code) {
        this.code = code;
    }

    public ResponseBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseBean(String code, String message, T entry) {
        this.code = code;
        this.message = message;
        this.entry = entry;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getEntry() {
        return entry;
    }

    public void setEntry(T entry) {
        this.entry = entry;
    }
}
