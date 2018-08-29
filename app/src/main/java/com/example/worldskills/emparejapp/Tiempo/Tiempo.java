package com.example.worldskills.emparejapp.Tiempo;

import android.os.SystemClock;
import android.widget.Chronometer;

public class Tiempo {

    long detenerse;
    Boolean running = false;

    public void iniciarchronometro(Chronometer chronometro){
        if (running){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
        }
    }
}
