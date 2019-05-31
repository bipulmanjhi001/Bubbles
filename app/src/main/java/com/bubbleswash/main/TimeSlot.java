package com.bubbleswash.main;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.bubbleswash.R;
import java.util.Calendar;

public class TimeSlot extends AppCompatActivity {

    Button pickup_date,pickup_time,delivery_date,delivery_time;
    TextView pickup_date_text,delivery_date_text;
    CheckBox Pickup,Delivery;
    LinearLayout CONFIRM_ORDER;

    final Calendar c = Calendar.getInstance();
    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(Calendar.MINUTE);

    private int mYear, mMonth, mDay;
    String pickup_dates,pickup_times,delivery_dates,delivery_times;
    ImageView go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot);

        Toast.makeText(this, "Choose Pickup & Delivery slots", Toast.LENGTH_LONG).show();

        pickup_date=(Button)findViewById(R.id.pickup_date);
        pickup_date_text=(TextView)findViewById(R.id.pickup_date_text);
        delivery_date_text=(TextView)findViewById(R.id.delivery_date_text);
        pickup_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeSlot.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                pickup_dates = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        Pickup=(CheckBox)findViewById(R.id.Pickup);
        Pickup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                pickup_time.setVisibility(View.VISIBLE);
                pickup_date.setVisibility(View.VISIBLE);
            }
        });

        Delivery=(CheckBox)findViewById(R.id.Delivery);
        Delivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                delivery_time.setVisibility(View.VISIBLE);
                delivery_date.setVisibility(View.VISIBLE);
            }
        });

        pickup_time=(Button)findViewById(R.id.pickup_time);
        pickup_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimeSlot.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                pickup_times=pickup_dates+" "+hourOfDay+":"+minute;
                                pickup_date_text.setText(pickup_times);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        delivery_date=(Button)findViewById(R.id.delivery_date);
        delivery_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeSlot.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                delivery_dates = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        delivery_time=(Button)findViewById(R.id.delivery_time);
        delivery_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimeSlot.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                delivery_times=delivery_dates+" "+hourOfDay+":"+minute;
                                delivery_date_text.setText(delivery_times);
                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        pickup_date_text=(TextView) findViewById(R.id.pickup_date_text);
        delivery_date_text=(TextView) findViewById(R.id.delivery_date_text);
        Pickup=(CheckBox) findViewById(R.id.Pickup);
        Delivery=(CheckBox) findViewById(R.id.Delivery);

        CONFIRM_ORDER=(LinearLayout)findViewById(R.id.CONFIRM_ORDER);
        CONFIRM_ORDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMain = new Intent(TimeSlot.this, PlacedOrder.class);
                startActivity(openMain);
                finish();
            }
        });

        go_back=(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMain = new Intent(TimeSlot.this, AddressList.class);
                startActivity(openMain);
                finish();
            }
        });

    }
}
