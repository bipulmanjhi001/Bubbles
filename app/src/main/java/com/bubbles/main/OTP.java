package com.bubbles.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bubbles.R;

public class OTP extends AppCompatActivity {

    Button otp_verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        otp_verify=(Button)findViewById(R.id.otp_verify);
        otp_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMain = new Intent(OTP.this, Dashboard.class);
                startActivity(openMain);
                finish();
            }
        });
    }
}
