package com.wkr.androidutil.dialog;

import androidx.appcompat.app.AppCompatActivity;

public class DialogUtil {

    /**
     * show 提示对话框
     *
     * @param context
     * @param title
     * @param msg
     * @param okButton
     * @param okBtnClickListener
     */
    public static void showMessageDialog(AppCompatActivity context, String title, String msg, String okButton, BaseDialogUtil.OkBtnClickListener okBtnClickListener) {
        DialogFactory.getDialogUtil().showMessageDialog(context, title, msg, okButton, okBtnClickListener);
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
    public static void showMessageDialog(AppCompatActivity context, String title, String msg,
                                         String okButton, BaseDialogUtil.OkBtnClickListener okBtnClickListener,
                                         String cancelButton, BaseDialogUtil.CancelBtnClickListener cancelBtnClickListener) {
        DialogFactory.getDialogUtil().showMessageDialog(context, title, msg, okButton, okBtnClickListener, cancelButton, cancelBtnClickListener);

    }

    /**
     * show 等待的提示框
     *
     * @param context
     * @param msg
     */
    public static void showWaitDialog(AppCompatActivity context, String msg) {
        DialogFactory.getDialogUtil().showWaitDialog(context, msg);
    }

    /**
     * show 成功的提示框
     *
     * @param context
     */
    public static void showSuccessDialog(AppCompatActivity context) {
        DialogFactory.getDialogUtil().showSuccessDialog(context);
    }

    /**
     * show 成功的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 超时时间
     */
    public static void showSuccessDialog(AppCompatActivity context, String msg, int timeOut) {
        DialogFactory.getDialogUtil().showSuccessDialog(context, msg, timeOut);
    }

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     */
    public static void showErrorDialog(AppCompatActivity context, String msg) {
        DialogFactory.getDialogUtil().showErrorDialog(context, msg);
    }

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 超时时间
     */
    public static void showErrorDialog(AppCompatActivity context, String msg, int timeOut) {
        DialogFactory.getDialogUtil().showErrorDialog(context, msg, timeOut);
    }


    /***
     * 手动关闭等待框
     */
    public static void dismiss() {
        DialogFactory.getDialogUtil().dismiss();
    }


}
