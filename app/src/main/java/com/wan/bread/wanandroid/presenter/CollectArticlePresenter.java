package com.wan.bread.wanandroid.presenter;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.model.api.Response;
import com.wan.bread.wanandroid.model.entity.CollectArticleBean;
import com.wan.bread.wanandroid.net.ApiService;
import com.wan.bread.wanandroid.net.observer.ProgressObserver;
import com.wan.bread.wanandroid.presenter.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by spp on 2019/4/10 0010.
 *
 *
 */

public class CollectArticlePresenter extends BasePresenter<CollectArticleContract.View> implements CollectArticleContract.Presenter {

    private CollectArticleContract.View mView;
    private ApiService apiService;

    @Inject
    public CollectArticlePresenter(CollectArticleContract.View mView, ApiService apiService) {
        this.mView = mView;
        this.apiService = apiService;
    }

    @Override
    public void getCollectArticle(String pageNum) {
        if (!isViewAttached()){
            return;
        }
        apiService.getCollectArticle(pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(mView.<Response<CollectArticleBean>>bindAutoDispose())
                .subscribe(new ProgressObserver<CollectArticleBean>((Context) mView) {
                    @Override
                    public void onSuccess(CollectArticleBean result) {
                        Logger.d("CollectArticlePresenter --> onSuccess");
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        Logger.d("CollectArticlePresenter --> onSuccess");
                    }
                });
    }
}
