package com.wan.bread.wanandroid.net;

import com.wan.bread.wanandroid.model.api.Response;
import com.wan.bread.wanandroid.model.entity.CollectArticleBean;
import com.wan.bread.wanandroid.model.entity.LoginBean;
import com.wan.bread.wanandroid.model.entity.SubscriptionNumListBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by spp on 2019/4/3 0003.
 *
 *
 */

public interface ApiService {

    /**
     * 获取公众号列表
     * @return Observable
     */
    @GET("wxarticle/chapters/json")
    Observable<Response<List<SubscriptionNumListBean>>> getSubscriptionNumList();

    /**
     * 登录接口
     * @param username 用户名
     * @param password 密码
     * @return Observable
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<Response<LoginBean>> login(@Field("username") String username,@Field("password") String password);

    /**
     * 收藏文章列表
     * @param pageNumber  页码  从0开始
     * @return Observable
     */
    @GET("lg/collect/list/{pageNum}/json")
    Observable<Response<CollectArticleBean>> getCollectArticle(@Path("pageNum") String pageNumber);

}
