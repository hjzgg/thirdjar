package com.hjzgg.test.thirdjar.common.exception;


public class ValueError extends BaseException {

    private String code;
    private String message;

    public ValueError(String code, String message) {
        super(code, message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
