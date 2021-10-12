package com.wkr.androidutil.dialog;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseDialogUtil {
    //默认状态框显示时间
    public static final int TIP_DIALOG_TIMEOUT = 6000;


    /**
     * show 提示对话框
     *
     * @param context
     * @param title
     * @param msg
     * @param okButton
     * @param okBtnClickListener
     */
    public abstract void showMessageDialog(AppCompatActivity context, String title, String msg, String okButton, OkBtnClickListener okBtnClickListener);

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
    public abstract void showMessageDialog(AppCompatActivity context, String title, String msg,
                                           String okButton, OkBtnClickListener okBtnClickListener,
                                           String cancelButton, CancelBtnClickListener cancelBtnClickListener);

    /**
     * show 等待的提示框
     *
     * @param context
     * @param msg
     */
    public abstract void showWaitDialog(AppCompatActivity context, String msg);

    /**
     * show 成功的提示框
     *
     * @param context
     */
    public abstract void showSuccessDialog(AppCompatActivity context);

    /**
     * show 成功的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 超时时间
     */
    public abstract void showSuccessDialog(AppCompatActivity context, String msg, int timeOut);

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     */
    public abstract void showErrorDialog(AppCompatActivity context, String msg);

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 超时时间
     */
    public abstract void showErrorDialog(AppCompatActivity context, String msg, int timeOut);


    /***
     * 手动关闭等待框
     */
    public abstract void dismiss();

    //确定按钮的回调
    public interface OkBtnClickListener {
        void onClick();
    }

    //取消按钮的回调
    public interface CancelBtnClickListener {
        void onClick();
    }

}
