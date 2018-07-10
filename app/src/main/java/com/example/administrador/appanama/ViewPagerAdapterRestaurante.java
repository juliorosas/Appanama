package com.example.administrador.appanama;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerAdapterRestaurante extends PagerAdapter {

    ViewPager vp;
    View view;

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.restaurante_1,R.drawable.restaurante_2,R.drawable.restaurante_3,R.drawable.restaurante_4,R.drawable.restaurante_5,
            R.drawable.restaurante_6,R.drawable.restaurante_7,R.drawable.restaurante_8,R.drawable.restaurante_9,R.drawable.restaurante_10,R.drawable.restaurante_11,
            R.drawable.restaurante_12, R.drawable.restaurante_13, R.drawable.restaurante_14};


    public ViewPagerAdapterRestaurante(Context context) {
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
        view = layoutInflater.inflate(R.layout.layout_img_restaurante, null);
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