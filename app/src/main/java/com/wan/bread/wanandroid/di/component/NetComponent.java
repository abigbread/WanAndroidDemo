package com.wan.bread.wanandroid.di.component;

import com.wan.bread.wanandroid.di.module.NetModule;
import com.wan.bread.wanandroid.net.ApiService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */
@Component(modules = NetModule.class)
@Singleton
public interface NetComponent {
    ApiService getRequest();
    OkHttpClient getOkHttp();
    Retrofit getRetrofit();

}
