package com.wan.bread.wanandroid.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by spp on 2019/4/2 0002.
 * <p>
 * 网络框架管理类
 */

public class NetWorkManager {

    private static NetWorkManager mInstance;
    private static Retrofit mRetrofit;
    private static volatile ApiService apiService = null;

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) { // synchronized修饰一个类，所有对象共用同一把锁
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化
     */
    public void init() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // 初始化 OkHttp
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)  //对OkHttp添加Log
                .build();

        // 初始化 Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Constant.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService(){
        if (apiService ==null){
            synchronized (ApiService.class){
                apiService = mRetrofit.create(ApiService.class);
            }
        }
        return apiService;
    }


}
