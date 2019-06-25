package com.wan.bread.wanandroid.di.module;

import com.wan.bread.wanandroid.presenter.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * 登录 Module
 */
@Module
public class LoginModule{

    private LoginContract.View mView;

    public LoginModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public LoginContract.View provideLoginView(){
        return mView;
    }
}
