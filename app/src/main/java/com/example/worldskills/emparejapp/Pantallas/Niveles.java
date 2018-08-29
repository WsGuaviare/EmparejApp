package com.example.worldskills.emparejapp.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.worldskills.emparejapp.R;

public class Niveles extends AppCompatActivity {
    Button facil,medio,dificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);
        facil=findViewById(R.id.facilId);
        medio=findViewById(R.id.medioId);
        dificil=findViewById(R.id.dificilId);
        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Niveles.this,Juego.class);
                intent.putExtra("nivel",1);
                startActivity(intent);
            }
        });
        medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Niveles.this,Juego.class);
                intent.putExtra("nivel",2);
                startActivity(intent);
            }
        });
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Niveles.this,Juego.class);
                intent.putExtra("nivel",3);
                startActivity(intent);
            }
        });
    }
}
