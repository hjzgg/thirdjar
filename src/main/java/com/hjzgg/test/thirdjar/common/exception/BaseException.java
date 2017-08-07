package com.hjzgg.test.thirdjar.common.exception;


public abstract class BaseException extends Exception{

    private String code;
    private String message;

    protected BaseException(String code, String message) {
        this.code = code;
        this.message = message;
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

    @Override
    public String toString() {
        return "BaseException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
