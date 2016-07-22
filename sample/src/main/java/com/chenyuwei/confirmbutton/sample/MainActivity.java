package com.chenyuwei.confirmbutton.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.chenyuwei.confirmbutton.ConfirmButton;

public class MainActivity extends AppCompatActivity {

    private ConfirmButton btnConfirm;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnConfirm = (ConfirmButton) findViewById(R.id.btnConfirm);
        //btnConfirm.setConfirmText("1");
        //btnConfirm.setDoneText("2");
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText())) {
                    btnConfirm.setCurrentState(ConfirmButton.STATE_DONE);
                }
                else {
                    btnConfirm.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake_error));
                }
            }
        });

    }
}
