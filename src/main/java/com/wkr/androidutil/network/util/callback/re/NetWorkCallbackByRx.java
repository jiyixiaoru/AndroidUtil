package com.wkr.androidutil.network.util.callback.re;

public interface NetWorkCallbackByRx<T> {
    /**
     * 请求之前，UI线程
     */
    void onBefore();

    /**
     * 请求成功，返回
     */
    void onSuccess(T t);

    /**
     * 请求失败返回
     *
     * @param throwable
     */
    void onError(Throwable throwable);

    /**
     * 请求结束
     */
    void onEnd();
}
