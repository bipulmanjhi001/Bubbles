package com.bubbleswash.main;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bubbleswash.R;

public class AddressList extends AppCompatActivity {

   FloatingActionButton address_staff;
   ImageView go_back;
   LinearLayout review_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);

        address_staff=(FloatingActionButton)findViewById(R.id.address_staff);
        address_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator.ofFloat(address_staff, "rotation", 0f, 360f).setDuration(800).start();
                Intent intent=new Intent(AddressList.this, MapsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        go_back=(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMain = new Intent(AddressList.this, Dashboard.class);
                startActivity(openMain);
                finish();
            }
        });
        review_order=(LinearLayout)findViewById(R.id.review_order);
        review_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMain = new Intent(AddressList.this, TimeSlot.class);
                startActivity(openMain);
                finish();
            }
        });

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
    }

    @Override
    public void onBackPressed() {
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        Intent openMain = new Intent(AddressList.this, Dashboard.class);
        startActivity(openMain);
        finish();
    }
}
