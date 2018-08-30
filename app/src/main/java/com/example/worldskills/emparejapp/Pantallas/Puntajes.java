package com.example.worldskills.emparejapp.Pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.worldskills.emparejapp.Adaptadores.PuntajeAdapter;
import com.example.worldskills.emparejapp.BD.Crud;
import com.example.worldskills.emparejapp.Entidades.PuntajesVo;
import com.example.worldskills.emparejapp.Entidades.listaVo;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;

public class Puntajes extends AppCompatActivity {
    RecyclerView recycler;
    PuntajeAdapter adapterp;
    ArrayList<listaVo> lista;
    ArrayList<PuntajesVo> puntajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes);
        recycler=findViewById(R.id.contenedor);
        lista=new ArrayList<>();
        puntajes=new ArrayList<>();
        Crud crud =new Crud(this,"emparejados",null,1);
        crud.consultar(this,"tb_puntaje",lista);
        for(int i=0;i<3;i++) {
            puntajes.add(new PuntajesVo(lista.get(0+(i*4)).getNomMin(),lista.get(1+(i*4)).getNomMin(),lista.get(2+(i*4)).getNomMin(),lista.get(3+(i*4)).getNomMin(),lista.get(0+(i*4)).getPunSeg(),lista.get(1+(i*4)).getPunSeg(),lista.get(2+(i*4)).getPunSeg(),lista.get(3+(i*4)).getPunSeg(),lista.get(0+(i*4)).getTiempo(),lista.get(1+(i*4)).getTiempo(),lista.get(2+(i*4)).getTiempo(),lista.get(3+(i*4)).getTiempo()));
        }
        adapterp=new PuntajeAdapter(puntajes);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapterp);
    }
}
