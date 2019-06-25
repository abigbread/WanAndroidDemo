package com.wan.bread.wanandroid.presenter.base;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.uber.autodispose.AutoDisposeConverter;

/**
 * Created by spp on 2019/4/9 0009.
 *
 *
 */

public interface BaseView {

    /**
     * 展示异常信息
     *
     * @param e 异常
     */
    void showFailure(Throwable e);


    /**
     * 获得 provider 防止RxJava内存泄漏
     * @return LifecycleProvider
     */
     LifecycleProvider<ActivityEvent> getLifecycleProvider();

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();

}
