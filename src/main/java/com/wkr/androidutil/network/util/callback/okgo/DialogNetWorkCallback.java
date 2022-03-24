package com.wkr.androidutil.network.util.callback.okgo;

import androidx.appcompat.app.AppCompatActivity;

import com.wkr.androidutil.dialog.DialogUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public abstract class DialogNetWorkCallback<T> implements NetWorkCallback<T> {
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
    public void onSuccess(Call call, Response response) {
        DialogUtil.dismiss();
        success(call, response);
    }

    public abstract void success(Call call, Response response);

    @Override
    public void onError(Call call, Response response, Throwable e) {
        DialogUtil.dismiss();
        error(call, response, e);
    }

    public abstract void error(Call call, Response response, Throwable e);

    @Override
    public void onFinish() {

    }

    @Override
    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

    }

    @Override
    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

    }
}
