package com.example.worldskills.emparejapp.Pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.worldskills.emparejapp.R;

public class Menu extends AppCompatActivity {
    String player1,player2;
    Button iniciar,puntajes,configuracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        player1=getIntent().getStringExtra("player1");
        player2=getIntent().getStringExtra("player2");
        iniciar=findViewById(R.id.iniciarId);
        puntajes=findViewById(R.id.puntajesId);
        configuracion=findViewById(R.id.configuracionId);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Niveles.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);
            }
        });
        puntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Puntajes.class);
                startActivity(intent);
            }
        });
        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Configuracion.class);
                startActivity(intent);
            }
        });
    }
}
