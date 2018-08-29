package com.example.worldskills.emparejapp.Pantallas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.emparejapp.R;
import com.example.worldskills.emparejapp.Tiempo.Tiempo;

public class Niveles extends AppCompatActivity {
    Button facil,medio,dificil;
    String player1,player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        facil=findViewById(R.id.facilId);
        medio=findViewById(R.id.medioId);
        dificil=findViewById(R.id.dificilId);
        player1=getIntent().getStringExtra("player1");
        player2=getIntent().getStringExtra("player2");

        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Niveles.this,Juego.class);
                intent.putExtra("nivel",1);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);
            }
        });
        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Niveles.this,Juego.class);
                intent.putExtra("nivel",2);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);
            }
        });
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Niveles.this,Juego.class);
                intent.putExtra("nivel",3);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);
            }
        });
    }
}
