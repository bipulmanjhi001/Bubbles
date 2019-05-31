package com.bubbles.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bubbles.R;
import com.bubbles.main.AddressList;
import com.bubbles.model.ViewPagerAdapter;

public class Home  extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ViewPager viewPager;
    LinearLayout sliderDotspanel,proceed_button;
    private int dotscount;
    private ImageView[] dots;
    int count=0;
    int count2=0;
    Button other_button_map,proceed_now;

    Boolean a1=false,a2=false,a3=false,a4=false,a5=false,a6=false;
    LinearLayout other_button;

    //http://www.sanktips.com/2017/10/15/how-to-fetch-images-from-server-to-image-slider-with-viewpager-in-android-studio/

    LinearLayout machine_wash,wash_iron,premium_services,dry_clean,Home_Cleaning,Car_Cleaning;
    TextView machine_wash_text,wash_iron_text,premium_services_text,dry_clean_text;
    TextView Home_Cleaning_text,Car_Cleaning_text;

    public Home() {
    }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home, container, false);

        dry_clean=(LinearLayout)view.findViewById(R.id.dry_clean);
        dry_clean_text=(TextView)view.findViewById(R.id.dry_clean_text);

        machine_wash_text=(TextView)view.findViewById(R.id.machine_wash_text);
        machine_wash=(LinearLayout)view.findViewById(R.id.machine_wash);

        wash_iron_text=(TextView)view.findViewById(R.id.wash_iron_text);
        wash_iron=(LinearLayout)view.findViewById(R.id.wash_iron);

        premium_services_text=(TextView)view.findViewById(R.id.premium_services_text);
        premium_services=(LinearLayout)view.findViewById(R.id.premium_services);
        proceed_button=(LinearLayout)view.findViewById(R.id.proceed_button);

        other_button=(LinearLayout)view.findViewById(R.id.other_button);
        other_button_map=(Button)view.findViewById(R.id.other_button_map);
        other_button_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AddressList.class);
                startActivity(intent);
                getActivity().finish();

            }
        });
        proceed_now=(Button)view.findViewById(R.id.proceed_now);
        proceed_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AddressList.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        Car_Cleaning_text=(TextView)view.findViewById(R.id.Car_Cleaning_text);
        Home_Cleaning_text=(TextView)view.findViewById(R.id.Home_Cleaning_text);

        Car_Cleaning=(LinearLayout)view.findViewById(R.id.Car_Cleaning);
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
        Home_Cleaning=(LinearLayout)view.findViewById(R.id.Home_Cleaning);
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
        machine_wash=(LinearLayout)view.findViewById(R.id.machine_wash);
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
        wash_iron=(LinearLayout)view.findViewById(R.id.wash_iron);
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
        premium_services=(LinearLayout)view.findViewById(R.id.premium_services);
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

        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout)view.findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.active_dot));
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
