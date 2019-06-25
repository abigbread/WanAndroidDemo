package com.wan.bread.wanandroid.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.wan.bread.wanandroid.R;
import com.wan.bread.wanandroid.WanApplication;
import com.wan.bread.wanandroid.di.component.DaggerCollectArticleComponent;
import com.wan.bread.wanandroid.di.module.CollectArticleModule;
import com.wan.bread.wanandroid.model.entity.CollectArticleBean;
import com.wan.bread.wanandroid.presenter.CollectArticleContract;
import com.wan.bread.wanandroid.presenter.CollectArticlePresenter;
import com.wan.bread.wanandroid.view.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by lujuanjuan on 2019/4/10 0010.
 *
 * 收藏
 */

public class CollectArticleActivity extends BaseActivity<CollectArticlePresenter> implements CollectArticleContract.View{

    @Inject
    CollectArticlePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.collect_article_act_layout;
    }

    @Override
    public void initView() {
        setHeaderTitle("收藏");
        DaggerCollectArticleComponent.builder()
                .collectArticleModule(new CollectArticleModule(this))
                .netComponent(WanApplication.getInstance().getNetComponent())
                .build()
                .inject(this);
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    public void initData() {
        presenter.getCollectArticle("0");
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void showFailure(Throwable e) {

    }

    @Override
    public void updateData(CollectArticleBean collectArticleBean) {

    }
}
