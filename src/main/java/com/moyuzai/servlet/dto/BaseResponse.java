package com.moyuzai.servlet.dto;

/**
 * Created by xiang on 2017/6/21.
 */
public class BaseResponse<T> {
    protected boolean state;
    protected T data;
    protected String errorInfo;

    public BaseResponse() {
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
