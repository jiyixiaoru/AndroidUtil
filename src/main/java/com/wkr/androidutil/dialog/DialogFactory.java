package com.wkr.androidutil.dialog;

import com.wkr.androidutil.dialog.dialog1.DialogUtilBy1;
import com.wkr.androidutil.dialog.dialogV3.DialogUtilByV3;

/**
 * dialogUtil工厂类
 */
public class DialogFactory {
    private static final int type = 1;//1:dialog1 ;2:dialogV3
    private static BaseDialogUtil dialogUtil;

    public static BaseDialogUtil getDialogUtil() {
        synchronized (DialogFactory.class) {
            if (dialogUtil == null) {
                synchronized (DialogFactory.class) {
                    if (type == 1) {
                        dialogUtil = new DialogUtilBy1();
                    } else if (type == 2) {
                        dialogUtil = new DialogUtilByV3();
                    }
                }
            }
        }
        return dialogUtil;
    }

}
