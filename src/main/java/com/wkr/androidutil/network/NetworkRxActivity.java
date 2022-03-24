package com.wkr.androidutil.network;

import android.view.View;

import com.google.gson.Gson;
import com.wkr.androidutil.BaseActivity;
import com.wkr.androidutil.R;
import com.wkr.androidutil.databinding.ActivityNetworkDelBinding;
import com.wkr.androidutil.network.bean.BaseResponseBean;
import com.wkr.androidutil.network.bean.RequestBean;
import com.wkr.androidutil.network.bean.ResponseBean;
import com.wkr.androidutil.network.util.callback.re.DialogNetWorkByRxCallback;
import com.wkr.androidutil.network.util.service.rerx.ApiController;

public class NetworkRxActivity extends BaseActivity<ActivityNetworkDelBinding> implements View.OnClickListener {
    private static final String TAG = "NetworkActivity";
    private RequestBean requestBean;

    @Override
    protected void setView() {
        setContentView(R.layout.activity_network_del);
    }

    @Override
    protected void initData() {
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
        ApiController.getHistoryRecords(requestBean,
                new DialogNetWorkByRxCallback<BaseResponseBean<ResponseBean>>(NetworkRxActivity.this, "获取历史记录请求中") {
                    @Override
                    public void onSuccess(BaseResponseBean<ResponseBean> responseBeanBaseResponseBean) {
                        binding.netResponse.setText(new Gson().toJson(responseBeanBaseResponseBean));
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        binding.netResponse.setText(throwable.toString());
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
    }
}
