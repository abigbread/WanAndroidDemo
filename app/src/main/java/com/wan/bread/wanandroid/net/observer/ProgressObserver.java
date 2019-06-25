package com.wan.bread.wanandroid.net.observer;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.model.api.Response;

import io.reactivex.disposables.Disposable;

/**
 * Created by spp on 2019/4/8 0008.
 * <p>
 * 有加载弹窗的 observer
 */

public abstract class ProgressObserver<T> extends BaseObserver<T> {
    private Context mContext;
    private String mLoadingText;
    private boolean mShowProgress;

    public ProgressObserver(Context context) {
        super(context);
        this.mContext = mContext;
    }

    /**
     *
     * @param context 上下文对象
     * @param mLoadingText 加载中文字描述
     * @param showProgress 是否展示加载框 ，true 为展示
     */
    public ProgressObserver(Context context, String mLoadingText, boolean showProgress) {
        super(context);
        this.mContext = context;
        this.mLoadingText = mLoadingText;
        this.mShowProgress = showProgress;
    }

    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
        if (mShowProgress)
            Logger.i(mLoadingText + " - onSubscribe");
    }

    @Override
    public void onNext(Response<T> result) {
        super.onNext(result);
        if (mShowProgress)
            Logger.i(mLoadingText + " - onNext");
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (mShowProgress)
            Logger.i(mLoadingText + " - onError");
    }

    @Override
    public void onComplete() {
        super.onComplete();
        if (mShowProgress)
            Logger.i(mLoadingText + " - onComplete");
    }

}
