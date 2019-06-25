package com.wan.bread.wanandroid.net.observer;

import android.content.Context;

import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.R;
import com.wan.bread.wanandroid.model.api.Response;
import com.wan.bread.wanandroid.net.ApiException;
import com.wan.bread.wanandroid.net.Constant;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by spp on 2019/4/8 0008.
 * <p>
 * 统一处理异常信息
 */

public abstract class BaseObserver<T> implements Observer<Response<T>> {

    private Context mContext;

    public BaseObserver(Context context) {
        this.mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Response<T> result) {
        if (result.getErrorCode() != Constant.RESPONSE_CODE_SUCCESS) {
            onError(new ApiException(result.getErrorCode(), result.getErrorMsg()));
        } else {
            onSuccess(result.getData());
        }
    }

    @Override
    public void onError(Throwable e) {
        String resultMsg = "未知异常";
        Logger.w("BaseObserver onError" + e);
        if (e instanceof UnknownHostException) {
            resultMsg = mContext.getString(R.string.server_internal_error);
        } else if (e instanceof SocketTimeoutException) {
            resultMsg = mContext.getString(R.string.cannot_connected_server);
        } else if (e instanceof HttpException) {
            resultMsg = convertStatusCode((HttpException) e);
        } else if (e instanceof IOException) {
            resultMsg = mContext.getString(R.string.cannot_connected_server);
        } else if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            if (exception.isTokenInvalid()) {
                resultMsg = mContext.getString(R.string.login_invalid);
                //处理token失效对应的逻辑
            } else {
                resultMsg = e.getMessage();
            }
        } else {
            //其他异常
        }
        ToastUtils.show(resultMsg);
        onFailure(resultMsg);
    }

    @Override
    public void onComplete() {

    }


    private String convertStatusCode(HttpException httpException) {
        String msg;
        if (httpException.code() >= 500 && httpException.code() < 600) {
            msg = mContext.getString(R.string.server_request_error);
        } else if (httpException.code() >= 400 && httpException.code() < 500) {
            msg = mContext.getString(R.string.server_not_handle);
        } else if (httpException.code() >= 300 && httpException.code() < 400) {
            msg = mContext.getString(R.string.request_redirect);
        } else {
            msg = httpException.message();
        }
        return msg;
    }

    public abstract void onSuccess(T result);

    public abstract void onFailure(String errorMsg);
}
