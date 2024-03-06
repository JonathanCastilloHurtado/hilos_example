package com.example.hilos_example;


import android.media.SoundPool;

public class EFECTOS extends  Thread {

boolean tears;
int TOTO,PIKA;
SoundPool soundPool;
EFECTOS(boolean tears,int TOTO,int PIKA, SoundPool soundPool){
    this.tears=tears;
    this.TOTO= TOTO;
    this.PIKA=PIKA;
    this.soundPool= soundPool;

}
    @Override
    public void run(){
        if(tears==true){
            soundPool.play(TOTO, 1, 1, 1, 0, 1);}
        else {soundPool.play(PIKA, 1, 1, 1, 0, 1);}
    }
}
