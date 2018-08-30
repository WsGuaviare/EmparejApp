package com.example.worldskills.emparejapp.Pantallas;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.worldskills.emparejapp.BD.Crud;
import com.example.worldskills.emparejapp.Entidades.listaVo;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    Button volver;
    String player1,player2,puntaje1,puntaje2,tiempo1,tiempo2,player3,puntaje3,tiempo3;
    int nivel;
    TextView jugador1,jugador2,score1,score2,time1,time2;
    ArrayList<listaVo> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        volver=findViewById(R.id.volver);
        lista=new ArrayList<>();
        player1=getIntent().getStringExtra("player1");
        player2=getIntent().getStringExtra("player2");
        puntaje1=getIntent().getStringExtra("puntaje1");
        puntaje2=getIntent().getStringExtra("puntaje2");
        nivel=getIntent().getIntExtra("nivel",0);
        //intent tiempo
        jugador1=findViewById(R.id.player1);
        jugador2=findViewById(R.id.player2);
        score1=findViewById(R.id.puntaje1);
        score2=findViewById(R.id.puntaje2);
        time1=findViewById(R.id.tiempo1);
        time2=findViewById(R.id.tiempo2);

        jugador1.setText(player1);
        jugador2.setText(player2);
        score1.setText(puntaje1);
        score2.setText(puntaje2);
        player3=player1;
        puntaje3=puntaje1;
        //tiempo
        if(nivel<4) {
            insertar();
        }
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Resultados.this,Menu.class);
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);
                finish();
            }
        });

    }

    private void insertar() {
        Crud crud=new Crud(this,"emparejados",null,1);
        crud.consultar(this,"tb_puntaje",lista);
        ContentValues registro=new ContentValues();
        registro.put("nombre",player3);
        registro.put("puntaje",puntaje3);

        for(int i=0;i<4;i++){
            if(Integer.valueOf(puntaje3)>=Integer.valueOf(lista.get(i+((nivel-1)*4)).getPunSeg())){
                for (int j=i;j<4;j++){
                    ContentValues registro1=new ContentValues();
                    registro1.put("nombre",lista.get(j+((nivel-1)*4)).getNomMin());
                    registro1.put("puntaje",lista.get(j+((nivel-1)*4)).getPunSeg());
                    crud.modificar(this,"tb_puntaje",String.valueOf(j+((nivel-1)*4)+2),registro1);
                }

                crud.modificar(this,"tb_puntaje",String.valueOf(i+((nivel-1)*4)+1),registro);

                break;
            }
        }
    }
}
