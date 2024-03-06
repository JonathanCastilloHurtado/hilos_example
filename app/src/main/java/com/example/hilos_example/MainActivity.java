package com.example.hilos_example;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ImageView IMA2,IMA;
    TextView texto;
    int TOTO,PIKA;
    SoundPool soundPool;
    boolean tears;
    AnimationDrawable frameAnimation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool( 5, AudioManager.STREAM_MUSIC , 0);
        TOTO=soundPool.load(this , R.raw.cry,0);
        PIKA=soundPool.load(this , R.raw.cry2,0);

        IMA2 = (ImageView)findViewById(R.id.ima2);
        IMA = (ImageView)findViewById(R.id.ima);
        texto = (TextView) findViewById(R.id.textView);

        FONDO f=new FONDO();
        f.run(IMA);
    }



    public void ONE(View v) {
        texto.setText("PIKACHU IS EVOLVING");

        runOnUiThread(new Runnable() {//esta dentro de un hilo????
            public void run() {
                IMA2.setBackgroundResource(R.drawable.chu);//le colocamos el xml con la animacion que creamos
                frameAnimation2 = (AnimationDrawable) IMA2.getBackground();
                frameAnimation2.start();
                tears = false;
            }
        });



    }
    public void DOS(View v) {

        texto.setText("TOTODILE IS EVOLVING");
        runOnUiThread(new Runnable() {//esta dentro de un hilo????
            public void run() {
                IMA2.setBackgroundResource(R.drawable.dos);//le colocamos el xml con la animacion que creamos
                frameAnimation2 = (AnimationDrawable) IMA2.getBackground();
                // frameAnimation2.setOneShot(true);//este hace que la animacion solo se recorra una vez , si se quiciera recorrer en loop se puede poner flase o no poner esta linea
                frameAnimation2.start();
                tears = true;
            }
        });



    }

    public void conHilos(){
        new CALCULOS().execute();
    }
    public void sinHilos(){
        int i;
        for(i=0;i<100000;i++){
            Log.d("JOHN","i:"+i);
        }
    }

    public void CRY(View v) {
           // conHilos();
            sinHilos();
            EFECTOS hiloEf= new EFECTOS(tears,TOTO,PIKA,soundPool);
            hiloEf.run();



    }

    public void TRES(View v) {
//STOP
        if(frameAnimation2.isRunning()==true){
            frameAnimation2.stop();
        }else{ System.out.print("AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");}

    }

    public void MP3(View v) {

        MUSICA Hilo= new MUSICA(MediaPlayer.create(MainActivity.this, R.raw.evol));
        Hilo.run();
    }

}