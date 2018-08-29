package com.example.worldskills.emparejapp.Tiempo;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

public class Tiempo {

    long detenerse; //esta variable la utilizamos para pausar el chronometro
    Boolean running = false;// esta variable la utilizamos para saber si el chronometro esta iniciado

//con este metodo iniciamos el chronometro
    public void iniciarchronometro(Chronometer chronometro){
        if (running){
            chronometro.setBase(SystemClock.elapsedRealtime() - detenerse);
            chronometro.start();
            running = true;
        }
    }

//con este metodo pausamos el chronometro
    public void pausarchronometro(Chronometer chronometro){
        if (!running){
            chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - chronometro.getBase();
            running = false;
        }
    }

//con este metodo reiniciamos el chronometro
    public void reiniciarchronometro(Chronometer chronometro){
        chronometro.setBase(SystemClock.elapsedRealtime());
        detenerse = 0;
        chronometro.stop();
    }

//con este metodo iniciamos un temporizador
    public void temporizador(final TextView mostrar, int minu, int segu){
        int tiempom = (minu * 60) * 1000;
        int tiempos = segu * 1000;
        int valor = tiempom + tiempos;

        CountDownTimer tiempo = new CountDownTimer(valor,1000) {
            @Override
            public void onTick(long l) {
                long corriendo = l / 1000;
                long min = corriendo / 60;
                long seg = corriendo % 60;
                String minutos = String.format("%02d",min);
                String segundos = String.format("%02d",seg);
                mostrar.setText("" + minutos +" : "+segundos);
            }

            @Override
            public void onFinish() {
                mostrar.setText("Paila!");

            }
        }.start();
    }
}
