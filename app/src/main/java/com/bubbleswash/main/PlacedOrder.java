package com.bubbleswash.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bubbleswash.R;

public class PlacedOrder extends AppCompatActivity {
    LinearLayout address_staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_placed_order);
        address_staff=(LinearLayout)findViewById(R.id.address_staff);
        address_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMain = new Intent(PlacedOrder.this, Dashboard.class);
                startActivity(openMain);
                finish();
            }
        });
    }
}
