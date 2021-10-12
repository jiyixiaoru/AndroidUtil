package com.wkr.androidutil.dialog.dialog1;

import android.os.CountDownTimer;

public class TickTimer extends CountDownTimer {

    public interface TickTimerListener {
        public void onFinish();

        public void onTick(long leftTime);
    }

    private TickTimerListener listener;

    public void setTimeCountListener(TickTimerListener listener) {
        this.listener = listener;
    }

    public TickTimer(long timeout, long tickInterval) {
        super(timeout , tickInterval * 1000);
    }

    @Override
    public void onFinish() {
        if (listener != null)
            listener.onFinish();
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if (listener != null)
            listener.onTick(millisUntilFinished / 1000);
    }

}
