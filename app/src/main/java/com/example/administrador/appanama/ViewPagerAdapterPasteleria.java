package com.example.administrador.appanama;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapterPasteleria extends PagerAdapter {

    ViewPager vp;
    View view;

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.pasteles_1,R.drawable.pasteles_2,R.drawable.pasteles_3,R.drawable.pasteles_4,R.drawable.pasteles_5,
            R.drawable.pasteles_6,R.drawable.pasteles_7,R.drawable.pasteles_8,R.drawable.pasteles_9,R.drawable.pasteles_10,R.drawable.pasteles_11};


    public ViewPagerAdapterPasteleria(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.layout_img_pasteleria, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        vp = (ViewPager) container;
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