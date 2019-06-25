package com.wan.bread.wanandroid.di.component;

import com.wan.bread.wanandroid.di.module.CollectArticleModule;
import com.wan.bread.wanandroid.di.scope.UserScope;
import com.wan.bread.wanandroid.view.activity.CollectArticleActivity;

import dagger.Component;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * 收藏
 */
@UserScope
@Component(modules = CollectArticleModule.class,dependencies = NetComponent.class)
public interface CollectArticleComponent {
    void inject(CollectArticleActivity collectArticleActivity);
}
