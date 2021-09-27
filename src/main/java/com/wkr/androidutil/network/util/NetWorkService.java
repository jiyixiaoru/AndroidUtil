package com.wkr.androidutil.network.util;

/***
 * 定义一些网络请求类型及一些基本参数
 */
public interface NetWorkService {

    /***
     * json格式的post请求
     * @param jsonStr
     */
    void post(String jsonStr);

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
}
