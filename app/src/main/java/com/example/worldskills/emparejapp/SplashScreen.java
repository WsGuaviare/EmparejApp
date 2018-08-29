package com.example.worldskills.emparejapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.worldskills.emparejapp.BD.Crud;
import com.example.worldskills.emparejapp.Pantallas.Inicio;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Crud crud=new Crud(this,"emparejados",null,1);
        crud.iniciarDB(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inicio = new Intent(getApplicationContext(),Inicio.class);
                startActivity(inicio);

            }
        },2000);

    }
}
