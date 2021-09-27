package com.wkr.androidutil.dialog;

import android.view.View;

import com.wkr.androidutil.BaseActivity;
import com.wkr.androidutil.R;
import com.wkr.androidutil.databinding.ActivityDialogBinding;
import com.wkr.androidutil.toast.ToastUtil;

public class DialogActivity extends BaseActivity<ActivityDialogBinding> implements View.OnClickListener {


    @Override
    protected void setView() {
        setContentView(R.layout.activity_dialog);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        binding.dialogMsg.setOnClickListener(this);
        binding.dialogWait.setOnClickListener(this);
        binding.dialogWaitDismiss.setOnClickListener(this);
        binding.dialogSuccess.setOnClickListener(this);
        binding.dialogError.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_msg:
                DialogUtil.showMessageDialog(DialogActivity.this, "友情提示", "您的信用卡即将到期",
                        "确定", new DialogUtil.OkBtnClickListener() {
                            @Override
                            public void onClick() {
                                ToastUtil.showToast(DialogActivity.this, "点击了确定按钮");
                            }
                        }, "取消", new DialogUtil.CancelBtnClickListener() {
                            @Override
                            public void onClick() {
                                ToastUtil.showToast(DialogActivity.this, "点击了取消按钮");
                            }
                        });
                break;
            case R.id.dialog_wait:
                DialogUtil.showWaitDialog(DialogActivity.this, "网络数据加载中，请稍后");
                break;
            case R.id.dialog_wait_dismiss:
                DialogUtil.dismiss();
                break;
            case R.id.dialog_success:
                DialogUtil.showSuccessDialog(DialogActivity.this);
                break;
            case R.id.dialog_error:
                DialogUtil.showErrorDialog(DialogActivity.this, "网络请求错误");
                break;
        }
    }
}