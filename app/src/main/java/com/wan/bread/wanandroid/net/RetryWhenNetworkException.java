package com.wan.bread.wanandroid.net;


import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * Created by spp on 2019/4/12 0012.
 *
 * 网络连接失败重连
 *
 */

public class RetryWhenNetworkException implements Function<Observable<? extends Throwable>,ObservableSource<?>> {

    /**
     * 重连次数
     */
    private int count = 3;
    /**
     * 延迟时间 单位秒
     */
    private long delay = 3;
    /**
     * 叠加延迟 单位秒
     */
    private long increaseDelay = 3;


    public RetryWhenNetworkException(int count, long delay) {
        this.count = count;
        this.delay = delay;
    }

    public RetryWhenNetworkException(int count, long delay, long increaseDelay) {
        this.count = count;
        this.delay = delay;
        this.increaseDelay = increaseDelay;
    }

    @Override
    public ObservableSource<?> apply(Observable<? extends Throwable> observable) throws Exception {
        return observable.zipWith(Observable.range(1, count+1), new BiFunction<Throwable, Integer, Wrapper>() {
            @Override
            public Wrapper apply(Throwable throwable, Integer integer) throws Exception {
                return new Wrapper(throwable,integer);
            }
        }).flatMap(new Function<Wrapper, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Wrapper wrapper) throws Exception {

                if ((wrapper.throwable instanceof ConnectException
                        || wrapper.throwable instanceof SocketTimeoutException
                        || wrapper.throwable instanceof TimeoutException)
                        && wrapper.index < count+1) { //如果超出重试次数也抛出错误，否则默认是会进入onCompleted
                    return Observable.timer(delay + (wrapper.index - 1) * increaseDelay, TimeUnit.SECONDS);

                }

                return Observable.error(wrapper.throwable);
            }
        });
    }


    public static class Wrapper {
        public int index;
        public Throwable throwable;

        public Wrapper(Throwable throwable, int index) {
            this.index = index;
            this.throwable = throwable;
        }
    }
}
