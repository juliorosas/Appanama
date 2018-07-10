package com.example.administrador.appanama;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Intro extends Activity {

    private static int SPLASH_TIME_OUT = 1700;
    MediaPlayer escaner;
    Handler handler;
    Animation anim1;
    ImageView imgPrincipal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intro);
        imgPrincipal=(ImageView)findViewById(R.id.imgPrincipal);

        //escaner = MediaPlayer.create(this, R.raw.escaner);
        anim1 = AnimationUtils.loadAnimation(this, R.anim.move);
        imgPrincipal.setAnimation(anim1);
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Intro.this,Mapa.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}