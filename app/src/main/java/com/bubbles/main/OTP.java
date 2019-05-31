package com.bubbles.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bubbles.R;
import com.bubbles.api.URL;
import com.bubbles.model.ConnectivityReceiver;
import com.bubbles.model.VolleySingleton;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class OTP extends AppCompatActivity {

    Button otp_verify;
    String token,otp_numbers,mobile,otp;
    EditText otp_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            token = bundle.getString("token");
            mobile = bundle.getString("mobile");
            otp = bundle.getString("otp");

            Toast.makeText(getApplicationContext(),"your OTP : "+otp,Toast.LENGTH_LONG).show();
        }

        otp_number = (EditText) findViewById(R.id.otp);
        otp_verify = (Button) findViewById(R.id.otp_verify);
        otp_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkConnection();
            }
        });
    }
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            attemptOTP();
        } else {
            message = "connect your internet.";
            color = Color.RED;
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }
    private void attemptOTP() {
        otp_numbers = otp_number.getText().toString();
        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(otp_numbers)) {
            otp_number.setError("Invalid OTP");
            focusView = otp_number;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            Authenticate();
        }
    }
    public void Authenticate() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL.URL_OTP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);

                            if (obj.getBoolean("status")) {
                                String message = obj.getString("message");

                                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                intent.putExtra("mobile", mobile);
                                intent.putExtra("token", token);
                                startActivity(intent);
                                finish();

                                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                            } else if (!obj.getBoolean("status")) {

                                String error = obj.getString("error");
                                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getApplicationContext(), "Connection error..", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Check again..", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("mobileno", mobile);
                params.put("token", token);
                params.put("otp", otp_numbers);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
    @Override
    public void onBackPressed() {
        backButtonHandler();
        return;
    }
    public void backButtonHandler() {
        Intent forgot = new Intent(OTP.this, Login.class);
        startActivity(forgot);
        finish();
    }
}
