package com.wkr.androidutil.dialog.dialogV3;

import androidx.appcompat.app.AppCompatActivity;

import com.kongzue.dialog.util.DialogSettings;
import com.kongzue.dialog.v3.MessageDialog;
import com.kongzue.dialog.v3.TipDialog;
import com.kongzue.dialog.v3.WaitDialog;
import com.wkr.androidutil.dialog.BaseDialogUtil;

/**
 * dialog:
 * 参考：https://github.com/kongzue/DialogV3
 */
public class DialogUtilByV3 extends BaseDialogUtil {

    public static TipDialog tipDialog;

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
    public void showMessageDialog(AppCompatActivity context, String title, String msg, String okButton, BaseDialogUtil.OkBtnClickListener okBtnClickListener) {
        MessageDialog.build(context)
                .setTitle(title)
                .setMessage(msg)
                .setOkButton(okButton, (baseDialog, v) -> {
                    okBtnClickListener.onClick();
                    return false;
                }).show();
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
    public void showMessageDialog(AppCompatActivity context, String title, String msg, String okButton, BaseDialogUtil.OkBtnClickListener okBtnClickListener, String cancelButton, BaseDialogUtil.CancelBtnClickListener cancelBtnClickListener) {
        MessageDialog.build(context)
                .setTitle(title)
                .setMessage(msg)
                .setOkButton(okButton, ((baseDialog, v) -> {
                    okBtnClickListener.onClick();
                    return false;
                }))
                .setCancelButton(cancelButton, ((baseDialog, v) -> {
                    cancelBtnClickListener.onClick();
                    return false;
                })).show();
    }

    /**
     * show 等待的提示框
     *
     * @param context
     * @param msg
     */
    @Override
    public void showWaitDialog(AppCompatActivity context, String msg) {
        tipDialog = WaitDialog.show(context, msg)
                .setTheme(DialogSettings.THEME.LIGHT);//强制指定为亮色模式
    }

    /**
     * show 成功的提示框
     *
     * @param context
     */
    @Override
    public void showSuccessDialog(AppCompatActivity context) {
        showSuccessDialog(context, "Success!!!", TIP_DIALOG_TIMEOUT);
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
        showStateDialog(context, msg, TipDialog.TYPE.SUCCESS, timeOut);
    }

    /**
     * show 失败的提示框
     *
     * @param context
     * @param msg     提示信息
     */
    @Override
    public void showErrorDialog(AppCompatActivity context, String msg) {
        showErrorDialog(context, msg, TIP_DIALOG_TIMEOUT);
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
        showStateDialog(context, msg, TipDialog.TYPE.ERROR, timeOut);
    }

    /**
     * show 状态的提示框
     *
     * @param context
     * @param msg     提示信息
     * @param timeOut 自动关闭的时长（单位：毫秒）
     */
    private static void showStateDialog(AppCompatActivity context, String msg, TipDialog.TYPE type, int timeOut) {
        tipDialog = TipDialog.show(context, msg, type).setTipTime(timeOut);
    }

    /***
     * 手动关闭等待框
     */
    @Override
    public void dismiss() {
        if (tipDialog != null) {
            tipDialog.doDismiss();
            tipDialog = null;
        }
    }


}
