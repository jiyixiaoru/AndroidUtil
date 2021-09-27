package com.wkr.androidutil.network;

import android.view.View;

import com.wkr.androidutil.BaseActivity;
import com.wkr.androidutil.R;
import com.wkr.androidutil.databinding.ActivityNetworkBinding;

public class NetworkActivity extends BaseActivity<ActivityNetworkBinding> implements View.OnClickListener {

    @Override
    protected void setView() {
        setContentView(R.layout.activity_network);
    }

    @Override
    protected void initData() {

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

}
