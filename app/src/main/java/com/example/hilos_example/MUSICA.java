package com.example.hilos_example;

import android.media.MediaPlayer;

public class MUSICA extends Thread {

    MediaPlayer musica;
MUSICA(MediaPlayer musica){


    this.musica=musica;
}


    @Override
    public void run(){

    musica.start();
      System.out.println("RESULTADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO============" );


    }
}
