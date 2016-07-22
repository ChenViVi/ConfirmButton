package com.chenyuwei.confirmbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewAnimator;


/**
 * Created by froger_mcs on 01.12.14.
 */
public class ConfirmButton extends ViewAnimator {
    public static final int STATE_CONFIRM = 0;
    public static final int STATE_DONE = 1;
    private static final long DELAY_MILLIS = 2000;
    private int currentState;

    private TextView tvConfirm;
    private TextView tvDone;

    private Runnable revertStateRunnable = new Runnable() {
        @Override
        public void run() {
            setCurrentState(STATE_CONFIRM);
        }
    };

    public ConfirmButton(Context context) {
        super(context);
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_root, this, true);
        tvConfirm = (TextView) rootView.findViewById(R.id.tvConfirm);
        tvDone = (TextView) rootView.findViewById(R.id.tvDone);
    }

    public ConfirmButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_root, this, true);
        tvConfirm = (TextView) rootView.findViewById(R.id.tvConfirm);
        tvDone = (TextView) rootView.findViewById(R.id.tvDone);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        currentState = STATE_CONFIRM;
    }

    @Override
    protected void onDetachedFromWindow() {
        removeCallbacks(revertStateRunnable);
        super.onDetachedFromWindow();
    }

    public void setCurrentState(int state) {
        if (state == currentState) {
            return;
        }
        currentState = state;
        if (state == STATE_DONE) {
            setEnabled(false);
            postDelayed(revertStateRunnable, DELAY_MILLIS);
            setInAnimation(getContext(), R.anim.slide_in_done);
            setOutAnimation(getContext(), R.anim.slide_out_confirm);
        } else if (state == STATE_CONFIRM) {
            setEnabled(true);
            setInAnimation(getContext(), R.anim.slide_in_confirm);
            setOutAnimation(getContext(), R.anim.slide_out_done);
        }
        showNext();
    }

    public void setConfirmText(String text){
        tvConfirm.setText(text);
    }

    public void setDoneText(String text){
        tvDone.setText(text);
    }
}