package com.example.hilos_example;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class FONDO extends Thread {

    AnimationDrawable frameAnimation;

    public void run(ImageView a){

        a.setBackgroundResource(R.drawable.uno);
        frameAnimation = (AnimationDrawable) a.getBackground();
        frameAnimation.start();

    }
}
