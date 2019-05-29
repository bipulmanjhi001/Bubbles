package com.bubbles.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bubbles.R;
import com.bubbles.model.ViewPagerAdapter;


public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    LinearLayout sliderDotspanel,proceed_button;
    private int dotscount;
    private ImageView[] dots;
    int count=0;
    int count2=0;

    Boolean a1=false,a2=false,a3=false,a4=false,a5=false,a6=false;
    LinearLayout other_button;

    //http://www.sanktips.com/2017/10/15/how-to-fetch-images-from-server-to-image-slider-with-viewpager-in-android-studio/

    LinearLayout machine_wash,wash_iron,premium_services,dry_clean,Home_Cleaning,Car_Cleaning;
    TextView machine_wash_text,wash_iron_text,premium_services_text,dry_clean_text;
    TextView Home_Cleaning_text,Car_Cleaning_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        dry_clean=(LinearLayout)findViewById(R.id.dry_clean);
        dry_clean_text=(TextView)findViewById(R.id.dry_clean_text);

        machine_wash_text=(TextView)findViewById(R.id.machine_wash_text);
        machine_wash=(LinearLayout)findViewById(R.id.machine_wash);

        wash_iron_text=(TextView)findViewById(R.id.wash_iron_text);
        wash_iron=(LinearLayout) findViewById(R.id.wash_iron);

        premium_services_text=(TextView)findViewById(R.id.premium_services_text);
        premium_services=(LinearLayout) findViewById(R.id.premium_services);
        proceed_button=(LinearLayout)findViewById(R.id.proceed_button);

        other_button=(LinearLayout)findViewById(R.id.other_button);
        Car_Cleaning_text=(TextView)findViewById(R.id.Car_Cleaning_text);
        Home_Cleaning_text=(TextView)findViewById(R.id.Home_Cleaning_text);

        Car_Cleaning=(LinearLayout)findViewById(R.id.Car_Cleaning);
        Car_Cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a6) {
                    Car_Cleaning.setBackgroundColor(Color.parseColor("#FA6AA6"));
                    Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.white));

                    a6=true;
                    count2=count2+1;
                    if(count2 >= 1){

                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.VISIBLE);
                    }else {

                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
                else {

                    Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                    a6=false;
                    count2=count2-1;
                    if(count2 >= 1){
                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        other_button.setVisibility(View.VISIBLE);
                        proceed_button.setVisibility(View.GONE);
                    }else {

                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
            }
        });
        Home_Cleaning=(LinearLayout)findViewById(R.id.Home_Cleaning);
        Home_Cleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a5) {
                    Home_Cleaning.setBackgroundColor(Color.parseColor("#FA6AA6"));
                    Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.white));

                    a5=true;
                    count2=count2+1;
                    if(count2 >= 1){
                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        other_button.setVisibility(View.VISIBLE);
                        proceed_button.setVisibility(View.GONE);
                    }else {
                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
                else {

                    Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                    a5=false;
                    count2=count2-1;
                    if(count2 >= 1){

                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));


                        other_button.setVisibility(View.VISIBLE);
                        proceed_button.setVisibility(View.GONE);
                    }else {
                        dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));
                        machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));
                        wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));
                        premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
            }
        });
        dry_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a1) {
                    dry_clean.setBackgroundColor(Color.parseColor("#FA6AA6"));
                    dry_clean_text.setTextColor(getResources().getColor(android.R.color.white));

                    a1=true;
                   count=count+1;
                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
                else {

                    dry_clean.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    dry_clean_text.setTextColor(getResources().getColor(android.R.color.black));

                    a1=false;
                    count=count-1;
                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }

            }
        });
        machine_wash=(LinearLayout)findViewById(R.id.machine_wash);
        machine_wash.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!a2) {
                    machine_wash.setBackgroundColor(Color.parseColor("#FA6AA6"));
                    machine_wash_text.setTextColor(getResources().getColor(android.R.color.white));

                    a2=true;
                    count=count+1;
                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
                else {

                    machine_wash.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    machine_wash_text.setTextColor(getResources().getColor(android.R.color.black));

                    a2=false;
                    count=count-1;

                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {

                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
            }
        });
        wash_iron=(LinearLayout)findViewById(R.id.wash_iron);
        wash_iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a3) {
                    wash_iron.setBackgroundColor(Color.parseColor("#FA6AA6"));
                    wash_iron_text.setTextColor(getResources().getColor(android.R.color.white));

                    a3=true;
                    count=count+1;

                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {

                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
                else {

                    wash_iron.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    wash_iron_text.setTextColor(getResources().getColor(android.R.color.black));

                    a3=false;
                    count=count-1;
                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
            }
        });
        premium_services=(LinearLayout)findViewById(R.id.premium_services);
        premium_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a4) {
                    premium_services.setBackgroundColor(Color.parseColor("#FA6AA6"));
                    premium_services_text.setTextColor(getResources().getColor(android.R.color.white));

                    a4=true;
                    count=count+1;
                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
                else {

                    premium_services.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    premium_services_text.setTextColor(getResources().getColor(android.R.color.black));

                    a4=false;
                    count=count-1;
                    if(count >= 1){
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.VISIBLE);
                        other_button.setVisibility(View.GONE);
                    }else {
                        Home_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Home_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));
                        Car_Cleaning.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        Car_Cleaning_text.setTextColor(getResources().getColor(android.R.color.black));

                        proceed_button.setVisibility(View.GONE);
                        other_button.setVisibility(View.GONE);
                    }
                }
            }
        });

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_rate) {

        } else if (id == R.id.nav_services) {

        } else if (id == R.id.nav_support) {

        } else if (id == R.id.nav_faq) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
