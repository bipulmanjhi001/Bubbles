package com.bubbles.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.bubbles.R;
import com.bubbles.fragment.FAQ;
import com.bubbles.fragment.Home;
import com.bubbles.fragment.Orders;
import com.bubbles.fragment.Rate;
import com.bubbles.fragment.Services;
import com.bubbles.fragment.Support;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Class fragmentClass;
    DrawerLayout drawer;
    Fragment fragment = null;
    String token,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mobile = bundle.getString("mobile");
            token = bundle.getString("token");
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, new Home()).commit();
        setTitle("Home");

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

            fragmentClass = Home.class;

        } else if (id == R.id.nav_orders) {

            fragmentClass = Orders.class;

        } else if (id == R.id.nav_rate) {

            fragmentClass = Rate.class;

        } else if (id == R.id.nav_services) {

            fragmentClass = Services.class;

        } else if (id == R.id.nav_support) {

            fragmentClass = Support.class;

        } else if (id == R.id.nav_faq) {

            fragmentClass = FAQ.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
