package com.wan.bread.wanandroid.di.module;

import com.wan.bread.wanandroid.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */
@Module
public class MainModule {

    private final MainContract.View mView;

    public MainModule(MainContract.View mView) {
        this.mView = mView;
    }

    @Provides
    MainContract.View provideMainView(){
        return mView;
    }

}
