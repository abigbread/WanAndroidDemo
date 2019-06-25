package com.wan.bread.wanandroid.net;

import com.google.gson.annotations.SerializedName;

/**
 * Created by spp on 2019/4/8 0008.
 * <p>
 * 自定义请求响应码
 */

public class HTTPStatus {
    /**
     * 错误码
     */
    @SerializedName("errorCode")
    private int errorCode;
    /**
     * 错误信息
     * 可用来返回接口的说明
     */
    @SerializedName("errorMsg")
    private String errorMsg;

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


    /**
     *
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     *
     */
    public boolean isCodeInvalid() {
        return errorCode != Constant.RESPONSE_CODE_SUCCESS;
    }


}
