package com.example.worldskills.emparejapp.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.worldskills.emparejapp.Entidades.listaVo;
import com.example.worldskills.emparejapp.R;

import java.util.ArrayList;

public class PuntajeAdapter extends RecyclerView.Adapter<PuntajeAdapter.listaViewHolder> {
    ArrayList<listaVo> lista;

    public PuntajeAdapter(ArrayList<listaVo> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PuntajeAdapter.listaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,viewGroup);
        return new listaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PuntajeAdapter.listaViewHolder listaViewHolder, int i) {
        listaViewHolder.player1.setText(lista.get(i).getNomMin());
        listaViewHolder.player2.setText(lista.get(i).getNomMin());
        listaViewHolder.player3.setText(lista.get(i).getNomMin());
        listaViewHolder.player4.setText(lista.get(i).getNomMin());
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
