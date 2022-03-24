package com.wkr.androidutil.network;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.wkr.androidutil.BaseActivity;
import com.wkr.androidutil.R;
import com.wkr.androidutil.databinding.ActivityNetworkDelBinding;
import com.wkr.androidutil.dialog.DialogUtil;
import com.wkr.androidutil.network.bean.BaseResponseBean;
import com.wkr.androidutil.network.bean.RequestBean;
import com.wkr.androidutil.network.bean.ResponseBean;
import com.wkr.androidutil.network.util.NetWorkService;
import com.wkr.androidutil.network.util.callback.okgo.DialogNetWorkCallback;
import com.wkr.androidutil.network.util.service.okgo.NetWorkServiceByOkGo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class NetworkOkGoActivity extends BaseActivity<ActivityNetworkDelBinding> implements View.OnClickListener {
    private static final String URL = "http://192.168.123.223:8200/api/getHistoryRecords";
    private static final String TAG = "NetworkActivity";
    private NetWorkService netWorkService;
    private RequestBean requestBean;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_network_del);
    }

    @Override
    protected void initData() {
        netWorkService = new NetWorkServiceByOkGo();
        requestBean = new RequestBean();
        requestBean.setDeviceId("1170000806");
        requestBean.setTransTicketNo("");
        requestBean.setStartDate("2019-09-06");
        requestBean.setEndDate("2020-03-11");
    }

    @Override
    protected void initListener() {
        binding.netPost.setOnClickListener(this);
        binding.netGet.setOnClickListener(this);
        binding.netDownFile.setOnClickListener(this);
        binding.netUpFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.net_post:
                post();
                break;

            case R.id.net_get:

                break;
            case R.id.net_down_file:

                break;
            case R.id.net_up_file:
                break;
        }

    }

    //post请求
    private void post() {
        netWorkService.post(URL, new Gson().toJson(requestBean), TAG,
                new DialogNetWorkCallback<BaseResponseBean<ResponseBean>>(NetworkOkGoActivity.this, "网络数据请求中") {
                    @Override
                    public void success(Call call, Response response) {
//                        DialogUtil.showSuccessDialog(NetworkActivity.this);
                        try {
                            binding.netResponse.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void error(Call call, Response response, Throwable e) {
                        DialogUtil.showErrorDialog(NetworkOkGoActivity.this, e.getMessage());
                        Log.e(TAG, response.toString());
                    }
                });
    }

    //get请求
    private void get() {
    }

    //下载文件
    private void downFile() {
    }

    //上传文件
    private void upFile() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        netWorkService.cancelByTag(TAG);
        netWorkService = null;
    }
}
