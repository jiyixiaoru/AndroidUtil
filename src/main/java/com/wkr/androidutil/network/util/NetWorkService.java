package com.wkr.androidutil.network.util;

import com.wkr.androidutil.network.util.callback.okgo.NetWorkCallback;

/***
 * 定义一些网络请求类型及一些基本参数
 */
public interface NetWorkService<T> {

    /***
     * json格式的post请求
     * @param url 请求地址
     * @param jsonStr 请求参数：json格式
     * @param tag   请求的tag,用于取消请求
     * @param netWorkCallback
     */
    void post(String url, String jsonStr, String tag, NetWorkCallback netWorkCallback);

    /***
     * get请求
     */
    void get();

    /**
     * 下载文件
     *
     * @param path
     */
    void downFile(String path);

    /**
     * 上传文件
     *
     * @param path
     */
    void upFile(String path);

    /**
     * 取消请求
     * @param tag
     */
    void cancelByTag(String tag);
}
