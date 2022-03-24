package com.wkr.androidutil.network;

import android.content.Intent;
import android.view.View;

import com.wkr.androidutil.BaseActivity;
import com.wkr.androidutil.R;
import com.wkr.androidutil.databinding.ActivityNetworkBinding;

public class NetworkActivity extends BaseActivity<ActivityNetworkBinding> {
    @Override
    protected void setView() {
        setContentView(R.layout.activity_network);
    }

    @Override
    protected void initData() {

    }

    /**
     * 协程+Retrofit参考 :https://github.com/xiangxiongfly/CoroutinesRetrofit/tree/main
     */
    @Override
    protected void initListener() {
        binding.netOkGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NetworkActivity.this, NetworkOkGoActivity.class));
            }
        });
        binding.netReRx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NetworkActivity.this, NetworkRxActivity.class));
            }
        });
    }
}
