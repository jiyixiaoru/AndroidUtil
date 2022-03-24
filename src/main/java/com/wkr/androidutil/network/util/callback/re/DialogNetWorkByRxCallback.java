package com.wkr.androidutil.network.util.callback.re;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.wkr.androidutil.dialog.DialogUtil;

public abstract class DialogNetWorkByRxCallback<T> implements NetWorkCallbackByRx<T> {
    private AppCompatActivity context;
    private String dialogMsg;

    public DialogNetWorkByRxCallback(AppCompatActivity context, String msg) {
        this.context = context;
        this.dialogMsg = msg;
    }

    @Override
    public void onBefore() {
        if (dialogMsg == null || dialogMsg.length() == 0) {
            dialogMsg = "数据加载中...";
        }
        DialogUtil.showWaitDialog(context, dialogMsg);
    }

    @Override
    public abstract void onSuccess(T t);

    @Override
    public abstract void onError(Throwable throwable);

    @Override
    public void onEnd() {
        DialogUtil.dismiss();
    }
}
