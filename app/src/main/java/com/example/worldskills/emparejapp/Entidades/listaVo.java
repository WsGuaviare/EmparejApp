package com.example.worldskills.emparejapp.Entidades;

public class listaVo {
    String nomMin,punSeg,tiempo;

    public listaVo(String nomMin, String punSeg, String tiempo) {
        this.nomMin = nomMin;
        this.punSeg = punSeg;
        this.tiempo = tiempo;
    }

    public String getNomMin() {
        return nomMin;
    }

    public void setNomMin(String nomMin) {
        this.nomMin = nomMin;
    }

    public String getPunSeg() {
        return punSeg;
    }

    public void setPunSeg(String punSeg) {
        this.punSeg = punSeg;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
