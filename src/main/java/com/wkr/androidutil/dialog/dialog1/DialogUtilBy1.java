package com.wkr.androidutil.dialog.dialog1;

import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

import com.wkr.androidutil.dialog.BaseDialogUtil;
import com.wkr.androidutil.toast.ToastUtil;

public class DialogUtilBy1 extends BaseDialogUtil {
    private static CustomAlertDialog dialog;

    /**
     * show 提示对话框
     *
     * @param context
     * @param title
     * @param msg
     * @param okButton
     * @param okBtnClickListener
     */
    @Override
    public void showMessageDialog(AppCompatActivity context, String title, String msg, String okButton, OkBtnClickListener okBtnClickListener) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.NORMAL_TYPE);
        dialog.show();
        dialog.setTitle(title);
        dialog.setContentText(msg);
        dialog.showConfirmButton(true);
        dialog.setConfirmText(okButton);
        dialog.setConfirmClickListener(new CustomAlertDialog.OnCustomClickListener() {
            @Override
            public void onClick(CustomAlertDialog alertDialog) {
                dialog.dismiss();
                okBtnClickListener.onClick();
            }
        });
    }

    /**
     * show 提示对话框
     *
     * @param context
     * @param title
     * @param msg
     * @param okButton
     * @param okBtnClickListener
     * @param cancelButton
     * @param cancelBtnClickListener
     */
    @Override
    public void showMessageDialog(AppCompatActivity context, String title, String msg, String okButton, OkBtnClickListener okBtnClickListener, String cancelButton, CancelBtnClickListener cancelBtnClickListener) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.NORMAL_TYPE);
        dialog.show();
        dialog.setTitle(title);
        dialog.setContentText(msg);
        dialog.showConfirmButton(true);
        dialog.setConfirmText(okButton);
        dialog.setConfirmClickListener(new CustomAlertDialog.OnCustomClickListener() {
            @Override
            public void onClick(CustomAlertDialog alertDialog) {
                dialog.dismiss();
                okBtnClickListener.onClick();
            }
        });
        dialog.setCancelText(cancelButton);
        dialog.showCancelButton(true);
        dialog.setCancelClickListener(new CustomAlertDialog.OnCustomClickListener() {
            @Override
            public void onClick(CustomAlertDialog alertDialog) {
                dialog.dismiss();
                cancelBtnClickListener.onClick();
            }
        });

    }

    /**
     * show 等待的提示框
     *
     * @param context
     * @param msg
     */
    @Override
    public void showWaitDialog(AppCompatActivity context, String msg) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.PROGRESS_TYPE);
        dialog.show();
        dialog.setCancelable(false);
        dialog.setTimeout(TIP_DIALOG_TIMEOUT);
        dialog.setTitleText("网络请求");
        dialog.setContentText(msg);
    }

    /**
     * show 成功的提示框
     *
     * @param context
     */
    @Override
    public void showSuccessDialog(AppCompatActivity context) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.SUCCESS_TYPE, TIP_DIALOG_TIMEOUT);
        dialog.showContentText(false);
        dialog.setTitleText("成功");
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ToastUtil.showToast(context, "---->onDismiss");
            }
        });
    }

    /**
     * show 成功的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 超时时间
     */
    @Override
    public void showSuccessDialog(AppCompatActivity context, String msg, int timeOut) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.SUCCESS_TYPE, timeOut);
        dialog.showContentText(false);
        dialog.setTitleText("成功");
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ToastUtil.showToast(context, "---->onDismiss");
            }
        });
    }

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     */
    @Override
    public void showErrorDialog(AppCompatActivity context, String msg) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.ERROR_TYPE, TIP_DIALOG_TIMEOUT);
        dialog.setTitleText("错误");
        dialog.setContentText(msg);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ToastUtil.showToast(context, "---->onDismiss");
            }
        });
    }

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 超时时间
     */
    @Override
    public void showErrorDialog(AppCompatActivity context, String msg, int timeOut) {
        dialog = null;
        dialog = new CustomAlertDialog(context, CustomAlertDialog.ERROR_TYPE, timeOut);
        dialog.setTitleText("错误");
        dialog.setContentText(msg);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ToastUtil.showToast(context, "---->onDismiss");
            }
        });
    }

    /***
     * 手动关闭等待框
     */
    @Override
    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
