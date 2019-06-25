package com.wan.bread.wanandroid;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.wan.bread.wanandroid.di.component.DaggerNetComponent;
import com.wan.bread.wanandroid.di.component.NetComponent;
import com.wan.bread.wanandroid.di.module.NetModule;

/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */

public class WanApplication extends Application {

    NetComponent netComponent;
    private static WanApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
        initNet();
        initDatabase();
        initToastUtils();
    }



    public static WanApplication getInstance(){
        return instance;
    }

    private void initLogger(){

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("WanAndroid")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
    private void initNet(){
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();
    }
    private void initDatabase(){

    }

    private void initToastUtils() {
        ToastUtils.init(this);
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
