package com.wan.bread.wanandroid.di.module;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.wan.bread.wanandroid.BuildConfig;
import com.wan.bread.wanandroid.WanApplication;
import com.wan.bread.wanandroid.net.ApiService;
import com.wan.bread.wanandroid.net.Constant;
import com.wan.bread.wanandroid.net.gson.CustomGsonConverterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(),new SharedPrefsCookiePersistor(WanApplication.getInstance()));

        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cookieJar(cookieJar)
                .build();
        return okhttpClient;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit retrofit  = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constant.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(CustomGsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    public ApiService provideRequest(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
