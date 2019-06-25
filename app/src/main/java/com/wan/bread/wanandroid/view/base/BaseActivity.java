package com.wan.bread.wanandroid.view.base;

import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.wan.bread.wanandroid.R;
import com.wan.bread.wanandroid.presenter.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by spp on 2019/4/8 0008.
 * <p>
 * 基类 Activity
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;
    private Unbinder unbinder;

    @BindView(R.id.header_title_tv)
    TextView headerTitle;

//    private final LifecycleProvider<ActivityEvent> provider
//            = NaviLifecycle.createActivityLifecycleProvider(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        attachView();
        initData();
        initListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 在 onCreate 中 attach ，在 onDestroy 中 detach
     */
    public abstract void attachView();

    /**
     * 初始化视图
     */
    public abstract void initData();

    /**
     * 初始化视图
     */
    public abstract void initListeners();

    /**
     * 设置标题栏 title
     * @param title 标题
     */
    public void setHeaderTitle(String title) {
        if (title != null && !title.isEmpty())
            headerTitle.setText(title);
    }

    /**
     * 跳转 activity 封装
     * @param cls 具体的 Activity.class
     */
    public void goTo(Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(this,cls);
        startActivity(intent);
    }


    /**
     * 获得 provider , 使用 lifecycle 需要继承 NaviActivity
     *
     * @return LifecycleProvider
     */
    public LifecycleProvider<ActivityEvent> getLifecycleProvider() {
//        return provider;
        return null;
    }

    //

    /**
     * 获得 AutoDisposeConverter , 使用 AutoDispose 需要继承 AppCompatActivity
     *
     * @return AutoDisposeConverter
     */
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider
                .from(this, Lifecycle.Event.ON_DESTROY));
    }



    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
        super.onDestroy();

    }
}
