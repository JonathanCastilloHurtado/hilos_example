package com.example.hilos_example;

import android.os.AsyncTask;
import android.util.Log;

public class CALCULOS extends AsyncTask<Object, Void, String> {
    @Override
    protected String doInBackground(Object... objects) {
        int i;
        for(i=0;i<100000;i++){
            Log.d("JOHN","i:"+i);
        }
        return "CALCULADO i "+i;
    }
}
