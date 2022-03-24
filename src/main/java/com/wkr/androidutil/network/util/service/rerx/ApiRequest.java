package com.wkr.androidutil.network.util.service.rerx;

import com.wkr.androidutil.network.bean.BaseResponseBean;
import com.wkr.androidutil.network.bean.RequestBean;
import com.wkr.androidutil.network.bean.ResponseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiRequest {

    //获取历史详情
    @POST("getHistoryRecords")
    Observable<BaseResponseBean<ResponseBean>> getHistoryRecords(@Body RequestBean requestBean);
}
