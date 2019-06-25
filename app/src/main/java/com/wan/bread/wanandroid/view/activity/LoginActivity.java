package com.wan.bread.wanandroid.view.activity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.orhanobut.logger.Logger;
import com.wan.bread.wanandroid.R;
import com.wan.bread.wanandroid.WanApplication;
import com.wan.bread.wanandroid.di.component.DaggerLoginComponent;
import com.wan.bread.wanandroid.di.module.LoginModule;
import com.wan.bread.wanandroid.model.entity.LoginBean;
import com.wan.bread.wanandroid.presenter.LoginContract;
import com.wan.bread.wanandroid.presenter.LoginPresenter;
import com.wan.bread.wanandroid.view.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by spp on 2019/4/8 0008.
 *
 *
 *
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View,View.OnClickListener {

    @BindView(R.id.login_confirm_btn)
    Button loginBtn;

    @BindView(R.id.login_account_et)
    EditText accountEt;

    @BindView(R.id.login_psd_et)
    EditText psdEt;

    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.login_act_layout;
    }

    @Override
    public void initView() {
        setHeaderTitle("登录");
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
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

    }

    @Override
    public void initListeners() {
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_confirm_btn:
                presenter.login("abigbread","harding1314");
                break;
        }
    }

    @Override
    public void showFailure(Throwable e) {

    }

    @Override
    public void saveLoginData(LoginBean data) {
        Logger.d(data);
    }
}
