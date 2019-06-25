package com.wan.bread.wanandroid.presenter;


import android.content.Context;

import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.net.ApiService;
import com.wan.bread.wanandroid.model.api.Response;
import com.wan.bread.wanandroid.model.entity.SubscriptionNumListBean;
import com.wan.bread.wanandroid.net.observer.ProgressObserver;
import com.wan.bread.wanandroid.presenter.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.View view;
    private ApiService apiService;

    private String mLoadingText;
    private boolean mShowProgress;

    @Inject
    public MainPresenter(MainContract.View view, ApiService apiService) {
        this.view = view;
        this.apiService = apiService;
    }

    @Override
    public void getSubscriptionNumList() {
        if (!isViewAttached()){
            return;
        }
        apiService.getSubscriptionNumList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .compose(view.getLifecycleProvider().<Response<List<SubscriptionNumListBean>>>bindToLifecycle()) // RxLifecycle
                .as(view.<Response<List<SubscriptionNumListBean>>>bindAutoDispose()) //AutoDispose
                .subscribe(new ProgressObserver<List<SubscriptionNumListBean>>((Context) view,mLoadingText,mShowProgress) {

                    @Override
                    public void onSuccess(List<SubscriptionNumListBean> result) {
                        Logger.i("BaseObserver --> onSuccess");
                        view.updateData(result);
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        Logger.i("BaseObserver --> onFailure");
                    }
                });

    }
    /**
     *
     * 设置需要的参数
     *
     * @param loadingText  加载中文字描述
     * @param showProgress 是否展示加载框 ，true 为展示
     */
    public void setParams(String loadingText,boolean showProgress){
        mLoadingText = loadingText;
        mShowProgress = showProgress;
    }


}
