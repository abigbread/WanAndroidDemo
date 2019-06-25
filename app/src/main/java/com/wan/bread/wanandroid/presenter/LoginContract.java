package com.wan.bread.wanandroid.presenter;

import com.wan.bread.wanandroid.model.entity.LoginBean;
import com.wan.bread.wanandroid.presenter.base.BaseView;

/**
 * Created by spp on 2019/4/10 0010.
 *
 */

public interface LoginContract {

    interface Presenter{
        void login(String username,String password);
    }

    interface View extends BaseView{
        @Override
        void showFailure(Throwable e);

        /**
         * 保存登录后的数据
         * @param data 登录后的数据
         */
        void saveLoginData(LoginBean data);
    }
}
