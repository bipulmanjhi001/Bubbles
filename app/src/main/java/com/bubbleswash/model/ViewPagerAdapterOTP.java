package com.bubbleswash.model;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.toolbox.ImageLoader;
import com.bubbleswash.R;
import java.util.List;

public class ViewPagerAdapterOTP extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<SliderUtilsOTP> sliderImg;
    private ImageLoader imageLoader;


    public ViewPagerAdapterOTP(List sliderImg, Context context) {
        this.sliderImg = sliderImg;
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderImg.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        SliderUtilsOTP utils = sliderImg.get(position);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(utils.getSliderImageUrl(), ImageLoader.getImageListener(imageView, R.drawable.ic_launcher_background, android.R.drawable.ic_dialog_alert));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(context, "To", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Bubbles", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}