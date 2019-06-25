package com.wan.bread.wanandroid.net;

import android.content.Context;

import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.R;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * Created by spp on 2019/4/8 0008.
 *
 *  异常统一处理
 *
 */

public class  BaseSubscriber<T> implements Subscriber<T> {

    protected Context mContext;

    public BaseSubscriber(Context context) {
        this.mContext = context;
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        String resultMsg = "未知异常";
        Logger.w("Subscriber onError"+ t);
        if (t instanceof HttpException) {
            // We had non-2XX http error
            resultMsg = mContext.getString(R.string.server_internal_error);
        } else if (t instanceof IOException) {
            // A network or conversion error happened
            resultMsg = mContext.getString(R.string.cannot_connected_server);
        } else if (t instanceof ApiException) {
            ApiException exception = (ApiException) t;
            if (exception.isTokenInvalid()) {
                //处理token失效对应的逻辑
                resultMsg = mContext.getString(R.string.login_invalid);
            } else {
                resultMsg = t.getMessage();
            }
        }

        ToastUtils.show(resultMsg);
    }

    @Override
    public void onComplete() {

    }
}
