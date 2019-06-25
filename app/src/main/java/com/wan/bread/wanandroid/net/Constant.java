package com.wan.bread.wanandroid.net;

import com.wan.bread.wanandroid.BuildConfig;

/**
 * Created by spp on 2019/4/8 0008.
 *
 *
 */

public class Constant {

    public static final String baseUrl = BuildConfig.BASE_URL;

    /**
     * errorCode 为0为成功，其他为失败
     */
    public static final int RESPONSE_CODE_SUCCESS = 0;

    /**
     * token 失效
     */
    public static final int TOKEN_INVALID = -1001;

}
