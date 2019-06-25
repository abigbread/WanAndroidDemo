package com.wan.bread.wanandroid.view.activity;

import androidx.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import com.wan.bread.wanandroid.R;
import com.wan.bread.wanandroid.WanApplication;
import com.wan.bread.wanandroid.di.component.DaggerMainComponent;
import com.wan.bread.wanandroid.di.module.MainModule;
import com.wan.bread.wanandroid.model.entity.SubscriptionNumListBean;
import com.wan.bread.wanandroid.presenter.MainContract;
import com.wan.bread.wanandroid.presenter.MainPresenter;
import com.wan.bread.wanandroid.view.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, View.OnClickListener {

    @BindView(R.id.go_to_login_btn)
    Button goToLoginBtn;

    @BindView(R.id.go_to_collect_article_btn)
    Button goToCollectArticleBtn;
    /**
     * 将 MainPresenter 注入到 MainActivity
     */
    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("onCreate");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
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
        goToLoginBtn.setOnClickListener(this);
        goToCollectArticleBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setParams("loading...", false);
        presenter.getSubscriptionNumList();
    }



    @Override
    public void showFailure(Throwable e) {

    }


    @Override
    public void updateData(List<SubscriptionNumListBean> data) {
        Logger.i("updateData --> " + data.toString());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_to_login_btn:
                goTo(LoginActivity.class);
                break;
            case R.id.go_to_collect_article_btn:
                goTo(CollectArticleActivity.class);
                break;
        }
    }
}
