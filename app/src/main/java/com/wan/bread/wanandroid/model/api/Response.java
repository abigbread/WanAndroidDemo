package com.wan.bread.wanandroid.model.api;

/**
 * Created by spp on 2019/4/3 0003.
 *
 *
 */

public class Response<T> {

    private T data; // 具体的数据结果
    private int errorCode; // 返回的code
    private String errorMsg; //

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
