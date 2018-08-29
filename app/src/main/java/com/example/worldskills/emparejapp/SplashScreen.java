package com.example.worldskills.emparejapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.worldskills.emparejapp.BD.Crud;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Crud crud=new Crud(this,"emparejados",null,1);
        crud.iniciarDB(this);
    }
}
