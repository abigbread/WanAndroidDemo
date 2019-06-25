package com.wan.bread.wanandroid.net;

/**
 * Created by spp on 2019/4/8 0008.
 *
 *
 *
 */

public class ApiException extends RuntimeException {

    private int errorCode;
    private String errorMsg;

    public ApiException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    /**
     * 判断是否是token失效
     *
     * @return 失效返回true, 否则返回false;
     */
    public boolean isTokenInvalid() {
        return errorCode == Constant.TOKEN_INVALID;
    }


}
