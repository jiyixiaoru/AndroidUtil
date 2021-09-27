package com.wkr.androidutil.network.util.callback;

import androidx.appcompat.app.AppCompatActivity;

import com.wkr.androidutil.dialog.DialogUtil;
import com.wkr.androidutil.network.util.NetWorkCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public abstract class DialogNetWorkCallback implements NetWorkCallback {
    private AppCompatActivity context;
    private String dialogMsg;

    public DialogNetWorkCallback(AppCompatActivity context, String dialogMsg) {
        this.context = context;
        this.dialogMsg = dialogMsg;
    }

    @Override
    public void onBefore(Request request) {
        if (dialogMsg == null || dialogMsg.length() == 0) {
            dialogMsg = "数据加载中...";
        }
        DialogUtil.showWaitDialog(context, dialogMsg);
    }

    @Override
    public void convertSuccess(Response response) {

    }

    @Override
    public void paseError(Call call, IOException e) {

    }

    @Override
    public abstract void onSuccess(Call call, Response response);

    @Override
    public abstract void onError(Call call, Response response, Exception e);

    @Override
    public void onAfter() {
        DialogUtil.dismiss();
    }

    @Override
    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

    }

    @Override
    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

    }
}