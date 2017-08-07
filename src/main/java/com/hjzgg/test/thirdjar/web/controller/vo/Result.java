package com.hjzgg.test.thirdjar.web.controller.vo;

import com.hjzgg.test.thirdjar.common.constant.CodeConstant;
import com.hjzgg.test.thirdjar.common.util.LogUtils;

public class Result<T> {

    private String code;

    private String message;

    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public static <T> Result success(T data) {
        Result result = new Result();
        result.code = CodeConstant.Normal.SUCCESS;
        result.message = CodeConstant.Normal.SUCCESS_MSG;
        result.data = data;
        LogUtils.resultLog(result);
        return result;
    }

    public static Result failure(String msg) {
        Result result = new Result();
        result.code = CodeConstant.Normal.FAILURE;
        result.message = msg;
        LogUtils.resultLog(result);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
