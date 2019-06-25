package com.wan.bread.wanandroid.presenter;

import com.wan.bread.wanandroid.model.entity.SubscriptionNumListBean;
import com.wan.bread.wanandroid.presenter.base.BaseView;

import java.util.List;

/**
 * Created by spp on 2019/4/4 0004.
 *
 *
 */

public interface MainContract {

    interface Presenter{
        void getSubscriptionNumList();
    }

    interface View extends BaseView {
        @Override
        void showFailure(Throwable e);

        /**
         * 更新数据
         *
         * @param data 请求得到的数据集合
         */
        void updateData(List<SubscriptionNumListBean> data);
    }

}
