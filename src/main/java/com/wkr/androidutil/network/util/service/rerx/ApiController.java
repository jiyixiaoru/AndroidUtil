package com.wkr.androidutil.network.util.service.rerx;

import com.wkr.androidutil.network.bean.BaseResponseBean;
import com.wkr.androidutil.network.bean.RequestBean;
import com.wkr.androidutil.network.bean.ResponseBean;
import com.wkr.androidutil.network.util.callback.re.NetWorkCallbackByRx;
import com.wkr.aspectj.net.NetWorkBehavior;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ApiController {
    private static ApiRequest apiRequest = ReRxHttpUtil.getRetrofit().create(ApiRequest.class);

    @NetWorkBehavior
    public static void getHistoryRecords(RequestBean requestBean, NetWorkCallbackByRx<BaseResponseBean<ResponseBean>> callback) {
        apiRequest.getHistoryRecords(requestBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBeanBaseResponseBean -> {
                    callback.onSuccess(responseBeanBaseResponseBean);
                    callback.onEnd();
                }, throwable -> {
                    callback.onError(throwable);
                    callback.onEnd();
                });
    }

}
