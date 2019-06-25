package com.wan.bread.wanandroid.di.component;

import com.wan.bread.wanandroid.view.activity.MainActivity;
import com.wan.bread.wanandroid.di.module.MainModule;
import com.wan.bread.wanandroid.di.scope.UserScope;

import dagger.Component;

/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */
@UserScope
@Component(modules = MainModule.class,dependencies = NetComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
