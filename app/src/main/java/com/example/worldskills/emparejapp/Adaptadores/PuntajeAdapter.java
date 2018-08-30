package com.example.worldskills.emparejapp.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldskills.emparejapp.Entidades.PuntajesVo;
import com.example.worldskills.emparejapp.Entidades.listaVo;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;

public class PuntajeAdapter extends RecyclerView.Adapter<PuntajeAdapter.listaViewHolder> {
    ArrayList<PuntajesVo> lista;

    public PuntajeAdapter(ArrayList<PuntajesVo> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PuntajeAdapter.listaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup,false);
        return new listaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PuntajeAdapter.listaViewHolder listaViewHolder, int i) {
        if(i==0) listaViewHolder.titulo.setText("Fácil");
        else if(i==1)listaViewHolder.titulo.setText("Medio");
        else if(i==2)listaViewHolder.titulo.setText("Difícil");
        listaViewHolder.player1.setText(lista.get(i).getPlayer1());
        listaViewHolder.player2.setText(lista.get(i).getPlayer2());
        listaViewHolder.player3.setText(lista.get(i).getPlayer3());
        listaViewHolder.player4.setText(lista.get(i).getPlayer4());
        listaViewHolder.puntaje1.setText(lista.get(i).getPuntaje1());
        listaViewHolder.puntaje2.setText(lista.get(i).getPuntaje2());
        listaViewHolder.puntaje3.setText(lista.get(i).getPuntaje3());
        listaViewHolder.puntaje4.setText(lista.get(i).getPuntaje4());
        listaViewHolder.tiempo1.setText(lista.get(i).getTiempo1());
        listaViewHolder.tiempo2.setText(lista.get(i).getTiempo2());
        listaViewHolder.tiempo3.setText(lista.get(i).getTiempo3());
        listaViewHolder.tiempo4.setText(lista.get(i).getTiempo4());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class listaViewHolder extends RecyclerView.ViewHolder {
        TextView player1,player2,player3,player4,puntaje1,puntaje2,puntaje3,puntaje4,tiempo1,tiempo2,tiempo3,tiempo4,titulo;
        public listaViewHolder(@NonNull View itemView) {
            super(itemView);
            player1=itemView.findViewById(R.id.jugador1);player2=itemView.findViewById(R.id.jugador2);player3=itemView.findViewById(R.id.jugador3);player4=itemView.findViewById(R.id.jugador4);
            puntaje1=itemView.findViewById(R.id.puntaje1);puntaje2=itemView.findViewById(R.id.puntaje2);puntaje3=itemView.findViewById(R.id.puntaje3);puntaje4=itemView.findViewById(R.id.puntaje4);
            tiempo1=itemView.findViewById(R.id.tiempo1);tiempo2=itemView.findViewById(R.id.tiempo2);tiempo3=itemView.findViewById(R.id.tiempo3);tiempo4=itemView.findViewById(R.id.tiempo4);
            titulo=itemView.findViewById(R.id.titulo);
        }
    }
}
