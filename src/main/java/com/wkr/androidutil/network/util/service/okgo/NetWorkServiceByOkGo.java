package com.wkr.androidutil.network.util.service.okgo;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.wkr.androidutil.network.util.callback.okgo.NetWorkCallback;
import com.wkr.androidutil.network.util.NetWorkService;

/***
 * OkGo网络实现类
 * * 参考：
 * * github原作者:https://github.com/jeasonlzy/okhttp-OkGo/wiki/Init#%E5%85%A8%E5%B1%80%E9%85%8D%E7%BD%AE
 * * 简书：https://www.jianshu.com/p/952f98d5c9fa
 *
 * 该类的回调具有如下顺序,虽然顺序写的很复杂,但是理解后,是很简单,并且合情合理的
 * 1.无缓存模式CacheMode.NO_CACHE
 * ---网络请求成功 onStart -> convertResponse -> onSuccess -> onFinish
 * ---网络请求失败 onStart -> onError -> onFinish
 * 2.默认缓存模式,遵循304头CacheMode.DEFAULT
 * ---网络请求成功,服务端返回非304 onStart -> convertResponse -> onSuccess -> onFinish
 * ---网络请求成功服务端返回304 onStart -> onCacheSuccess -> onFinish
 * ---网络请求失败 onStart -> onError -> onFinish
 * 3.请求网络失败后读取缓存CacheMode.REQUEST_FAILED_READ_CACHE
 * ---网络请求成功,不读取缓存 onStart -> convertResponse -> onSuccess -> onFinish
 * ---网络请求失败,读取缓存成功 onStart -> onCacheSuccess -> onFinish
 * ---网络请求失败,读取缓存失败 onStart -> onError -> onFinish
 * 4.如果缓存不存在才请求网络，否则使用缓存CacheMode.IF_NONE_CACHE_REQUEST
 * ---已经有缓存,不请求网络 onStart -> onCacheSuccess -> onFinish
 * ---没有缓存请求网络成功 onStart -> convertResponse -> onSuccess -> onFinish
 * ---没有缓存请求网络失败 onStart -> onError -> onFinish
 * 5.先使用缓存，不管是否存在，仍然请求网络CacheMode.FIRST_CACHE_THEN_REQUEST
 * ---无缓存时,网络请求成功 onStart -> convertResponse -> onSuccess -> onFinish
 * ---无缓存时,网络请求失败 onStart -> onError -> onFinish
 * ---有缓存时,网络请求成功 onStart -> onCacheSuccess -> convertResponse -> onSuccess -> onFinish
 * ---有缓存时,网络请求失败 onStart -> onCacheSuccess -> onError -> onFinish
 */
public class NetWorkServiceByOkGo<T> implements NetWorkService<T> {

    @Override
    public void post(String url, String jsonStr, String tag, NetWorkCallback netWorkCallback) {
        OkGo.post(url)
                .tag(tag)//用于取消请求
                .upJson(jsonStr)
                .headers("token", "123456")
                .execute((Callback<Object>) new Callback<T>() {
                    //请求网络开始前，UI线程
                    @Override
                    public void onStart(Request<T, ? extends Request> request) {
                        netWorkCallback.onBefore(request.getRequest());
                    }

                    //对返回数据进行操作的回调， UI线程
                    @Override
                    public void onSuccess(Response<T> response) {
                        netWorkCallback.onSuccess(response.getRawCall(), response.getRawResponse());
                    }

                    //缓存成功的回调,UI线程
                    @Override
                    public void onCacheSuccess(Response<T> response) {
                        netWorkCallback.onSuccess(response.getRawCall(), response.getRawResponse());
                    }

                    //请求失败，响应错误，数据解析错误等，都会回调该方法， UI线程
                    @Override
                    public void onError(Response<T> response) {
                        netWorkCallback.onError(response.getRawCall(), response.getRawResponse(), (Exception) response.getException());
                    }

                    //请求网络结束后，UI线程
                    @Override
                    public void onFinish() {
                        netWorkCallback.onFinish();
                    }

                    //上传过程中的进度回调，get请求不回调，UI线程
                    @Override
                    public void uploadProgress(Progress progress) {
                        netWorkCallback.upProgress(progress.currentSize, progress.totalSize, progress.fraction, progress.speed);
                    }

                    //下载过程中的进度回调，UI线程
                    @Override
                    public void downloadProgress(Progress progress) {
                        netWorkCallback.downloadProgress(progress.currentSize, progress.totalSize, progress.fraction, progress.speed);
                    }

                    //拿到响应后，将数据转换成需要的格式，子线程中执行，可以是耗时操作
                    //Params:
                    //response – 需要转换的对象
                    //Returns:
                    //转换后的结果
                    //Throws:
                    //Exception – 转换过程发生的异常
                    @Override
                    public T convertResponse(okhttp3.Response response) throws Throwable {
                        return null;
                    }
                });
    }

    @Override
    public void get() {

    }

    @Override
    public void downFile(String path) {

    }

    @Override
    public void upFile(String path) {

    }

    @Override
    public void cancelByTag(String tag) {
        //取消指定tag的请求
//        OkGo.getInstance().cancelTag(this);
        //取消全部请求
//        OkGo.getInstance().cancelAll();
        //取消OkHttpClient的全部请求
//        OkGo.cancelAll(new OkHttpClient());
//        OkGo.cancelTag(new OkHttpClient(), "且指定tag");
        OkGo.getInstance().cancelTag(tag);
    }
}
