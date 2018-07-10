package com.example.administrador.appanama;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;


public class FragmentPasteleria extends Fragment {

    ViewPager image_slider;
    private int time = 30;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 6000; // time in milliseconds between successive task executions.


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_pasteleria, container);

        image_slider = (ViewPager) retView.findViewById(R.id.image_slider);
        ViewPagerAdapterPasteleria viewPagerAdapter = new ViewPagerAdapterPasteleria(getActivity());
        image_slider.setAdapter(viewPagerAdapter);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 11) {
                    currentPage = 0;
                }
                image_slider.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        return retView;
    }

}