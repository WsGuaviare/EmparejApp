package com.example.worldskills.emparejapp.Pantallas;

import android.graphics.Color;
import android.media.Image;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.worldskills.emparejapp.R;

import java.net.JarURLConnection;
import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    int nivel,ran;
    ArrayList<ImageView> Ids;
    ArrayList<Integer> imagenes;
    ArrayList<Integer> juego;
    TextView nomJug1,nomJug2,punJug1,punJug2,tiempo;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nivel=getIntent().getIntExtra("nivel",0);
        Ids=new ArrayList<>();
        imagenes=new ArrayList<>();
        juego=new ArrayList<>();
        super.onCreate(savedInstanceState);
        //llenar el ArrayList con los ImageView
        if(nivel==1 || nivel==4) {
            setContentView(R.layout.activity_juego);
        }
        else if(nivel==2 || nivel==5){
            setContentView(R.layout.medio);
            Ids.add(img9=findViewById(R.id.imagen9));Ids.add(img10=findViewById(R.id.imagen10));Ids.add(img11=findViewById(R.id.imagen11));Ids.add(img12=findViewById(R.id.imagen12));
        }
        else if(nivel==3 || nivel==6){
            setContentView(R.layout.dificil);
            Ids.add(img9=findViewById(R.id.imagen9));Ids.add(img10=findViewById(R.id.imagen10));Ids.add(img11=findViewById(R.id.imagen11));Ids.add(img12=findViewById(R.id.imagen12));
            Ids.add(img13=findViewById(R.id.imagen13));Ids.add(img14=findViewById(R.id.imagen14));Ids.add(img15=findViewById(R.id.imagen15));Ids.add(img16=findViewById(R.id.imagen16));
        }
        Ids.add(img1=findViewById(R.id.imagen1));Ids.add(img2=findViewById(R.id.imagen2));Ids.add(img3=findViewById(R.id.imagen3));Ids.add(img4=findViewById(R.id.imagen4));Ids.add(img5=findViewById(R.id.imagen5));Ids.add(img6=findViewById(R.id.imagen6));Ids.add(img7=findViewById(R.id.imagen7));Ids.add(img8=findViewById(R.id.imagen8));
        nomJug1=findViewById(R.id.player1);
        nomJug2=findViewById(R.id.player2);
        punJug1=findViewById(R.id.puntaje1);
        punJug2=findViewById(R.id.puntaje2);
        tiempo=findViewById(R.id.tiempo);
        //obtener intent
        nomJug1.setText("Daniel");
        nomJug2.setText("Alirio");
        punJug1.setText("0");
        punJug2.setText("0");
        tiempo.setText("0");
        //seleccion random del jugador que inicia
        Random random=new Random(SystemClock.currentThreadTimeMillis());
        ran=random.nextInt(2)+1;
        GenerarJugadores();
        Log.d("verificar",String.valueOf(ran));
        imagenes.add(R.drawable.imagen1);imagenes.add(R.drawable.imagen2);imagenes.add(R.drawable.imagen3);imagenes.add(R.drawable.imagen4);imagenes.add(R.drawable.imagen5);imagenes.add(R.drawable.imagen6);imagenes.add(R.drawable.imagen7);imagenes.add(R.drawable.imagen8);imagenes.add(R.drawable.duda);
        ReiniciarCartas(0);
        GenerarCartas();
    }
    private void ReiniciarCartas(int donde){
        int ciclo=0;
        if(nivel==1 || nivel==4)ciclo=8;
        else if(nivel==2 || nivel==5)ciclo=12;
        else if(nivel==3 || nivel==6)ciclo=16;
        for(int i=0;i<ciclo;i++){
            if(donde==0){
                juego.add(0);
                Ids.get(i).setImageResource(0);
            }
            else {
                Ids.get(i).setImageResource(juego.get(i));
            }
        }
    }
    private void GenerarCartas(){
        int aleatorio=0,cartas=0;
        Random rnd=new Random(SystemClock.currentThreadTimeMillis());
        int posicion=0;
        if(nivel==1 || nivel==4){
            cartas=4;
            aleatorio=8;
        }
        else if(nivel==2 || nivel==5){
            cartas=6;
            aleatorio=12;
        }
        else if(nivel==3 || nivel==6){
            cartas=8;
            aleatorio=16;
        }
        for(int z=0;z<2;z++){
            posicion=rnd.nextInt(aleatorio);
            for(int i=0;i<cartas;i++){
                while (juego.get(posicion)!=0){
                    posicion=rnd.nextInt(aleatorio);
                }
                juego.set(posicion,imagenes.get(i));
                ReiniciarCartas(1);
            }
        }
    }
    private void GenerarJugadores(){
        if(ran==1){
            nomJug1.setTextColor(Color.parseColor("#000000"));
            punJug1.setTextColor(Color.parseColor("#000000"));
            nomJug2.setTextColor(Color.parseColor("#808080"));
            punJug2.setTextColor(Color.parseColor("#808080"));
        }
        else if(ran==2){
            nomJug2.setTextColor(Color.parseColor("#000000"));
            punJug2.setTextColor(Color.parseColor("#000000"));
            nomJug1.setTextColor(Color.parseColor("#808080"));
            punJug1.setTextColor(Color.parseColor("#808080"));
        }

    }
}
