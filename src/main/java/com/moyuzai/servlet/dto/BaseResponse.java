package com.moyuzai.servlet.dto;

/**
 * Created by xiang on 2017/6/21.
 */
public class BaseResponse<T> {
    protected boolean state;
    protected T data;
    protected String stateInfo;

    public BaseResponse() {
    }

    public BaseResponse(boolean state, T data) {
        this.state = state;
        this.data = data;
    }

    public BaseResponse(boolean state, String errorInfo) {
        this.state = state;
        this.stateInfo = errorInfo;
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

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
