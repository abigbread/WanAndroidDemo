package com.wan.bread.wanandroid.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.net.ApiService;
import com.wan.bread.wanandroid.model.api.Response;
import com.wan.bread.wanandroid.model.entity.LoginBean;
import com.wan.bread.wanandroid.net.RetryWhenNetworkException;
import com.wan.bread.wanandroid.net.observer.ProgressObserver;
import com.wan.bread.wanandroid.presenter.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * login presenter
 *
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private LoginContract.View mView;
    private ApiService apiService;

    @Inject
    public LoginPresenter(LoginContract.View mView, ApiService apiService) {
        this.mView = mView;
        this.apiService = apiService;
    }

    @Override
    public void login(String username, String password) {
        if (!isViewAttached()){
            return;
        }
        apiService.login(username,password)
                .retryWhen(new RetryWhenNetworkException(3,3))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(mView.<Response<LoginBean>>bindAutoDispose())
                .subscribe(new ProgressObserver<LoginBean>((Context) mView) {
                    @Override
                    public void onSuccess(LoginBean result) {
                        Logger.d("LoginPresenter --> onSuccess");
                        mView.saveLoginData(result);
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        Logger.d("LoginPresenter --> onFailure");
                        mView.showFailureMsg(errorMsg);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        mView.showFailure(e);
                    }
                });
    }
}
