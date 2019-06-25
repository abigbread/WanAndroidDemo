package com.wan.bread.wanandroid.di.component;

import com.wan.bread.wanandroid.di.module.LoginModule;
import com.wan.bread.wanandroid.di.scope.UserScope;
import com.wan.bread.wanandroid.view.activity.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * Login Component
 */

@UserScope
@Component(modules = LoginModule.class,dependencies = NetComponent.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
