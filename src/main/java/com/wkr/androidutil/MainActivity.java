package com.wkr.androidutil;

import android.content.Intent;
import android.view.View;

import com.wkr.androidutil.databinding.ActivityMainBinding;
import com.wkr.androidutil.dialog.DialogActivity;
import com.wkr.androidutil.network.NetworkActivity;
import com.wkr.androidutil.permission.PermissionActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements View.OnClickListener {

    @Override
    protected void setView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        binding.mainNetwork.setOnClickListener(this);
        binding.mainDialog.setOnClickListener(this);
        binding.mainPermission.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()) {
            case R.id.main_network:
                intent = new Intent(this, NetworkActivity.class);
                break;
            case R.id.main_dialog:
                intent = new Intent(this, DialogActivity.class);
                break;
            case R.id.main_permission:
                intent = new Intent(this, PermissionActivity.class);
                break;
        }
        startActivity(intent);
    }
}