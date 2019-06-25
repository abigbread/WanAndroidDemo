package com.wan.bread.wanandroid.presenter;

import com.wan.bread.wanandroid.model.entity.CollectArticleBean;
import com.wan.bread.wanandroid.presenter.base.BasePresenter;
import com.wan.bread.wanandroid.presenter.base.BaseView;

/**
 * Created by spp on 2019/4/10 0010.
 *
 * 收藏文章
 */

public interface CollectArticleContract {

    interface Presenter{
        void getCollectArticle(String pageNum);
    }

    interface View extends BaseView{
        @Override
        void showFailure(Throwable e);

        void updateData(CollectArticleBean collectArticleBean);
    }

}
