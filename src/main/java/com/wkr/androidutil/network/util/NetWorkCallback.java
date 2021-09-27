package com.wkr.androidutil.network.util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/***
 * 网络请求回调类
 */
public interface NetWorkCallback {
    /**
     * UI线程，请求网络之前
     * 可以显示对话框，添加/修改/移除 请求参数
     *
     * @param request
     */
    void onBefore(Request request);

    /***
     *  子线程，可以做耗时操作
     *  根据传递进来的 response 对象，把数据解析成需要的 ServerModel 类型并返回
     *  可以根据自己的需要，抛出异常，在onError中处理
     * @param response
     */
    void convertSuccess(Response response);

    /**
     * 子线程，可以做耗时操作
     * 用于网络错误时在子线程中执行数据耗时操作,子类可以根据自己的需要重写此方法
     *
     * @param call 本次网络的请求信息，如果需要查看请求头或请求参数可以从此对象获取
     * @param e    本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 404,或大于等于500
     */
    void paseError(Call call, IOException e);

    /***
     * UI 线程，请求成功后回调
     *
     * @param call  本次网络的请求信息，如果需要查看请求头或请求参数可以从此对象获取
     * @param response 本次网络访问的结果对象，包含了响应头，响应码等
     */
    void onSuccess(Call call, Response response);

    /***
     * UI 线程，请求失败后回调
     *
     * @param call 本次网络的请求对象，可以根据该对象拿到 request
     * @param response 本次网络访问的结果对象，包含了响应头，响应码等
     * @param e 本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 404,或大于等于500
     */
    void onError(Call call, Response response, Exception e);

    /**
     * UI 线程，请求结束后回调，无论网络请求成功还是失败，都会调用，可以用于关闭显示对话框
     */
    void onAfter();

    /**
     * UI 线程，文件上传过程中回调，只有请求方式包含请求体才回调（GET,HEAD不会回调）
     *
     * @param currentSize  当前上传的大小（单位字节）
     * @param totalSize    需要上传的总大小（单位字节）
     * @param progress     当前上传的进度，范围　0.0f ~ 1.0f
     * @param networkSpeed 当前上传的网速（单位秒）
     */
    void upProgress(long currentSize, long totalSize, float progress, long networkSpeed);

    /***
     * UI 线程，文件下载过程中回调
     *
     * @param currentSize  当前上传的大小（单位字节）
     * @param totalSize    需要上传的总大小（单位字节）
     * @param progress     当前上传的进度，范围　0.0f ~ 1.0f
     * @param networkSpeed 当前上传的网速（单位秒）
     */
    void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed);

}
