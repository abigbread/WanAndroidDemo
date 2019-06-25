package com.wan.bread.wanandroid.di.module;

import com.wan.bread.wanandroid.presenter.CollectArticleContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * 收藏
 *
 */
@Module
public class CollectArticleModule {

    private CollectArticleContract.View mView;

    public CollectArticleModule(CollectArticleContract.View mView) {
        this.mView = mView;
    }

    @Provides
    CollectArticleContract.View provideCollectArticleView(){
        return mView;
    }
}
