package com.example.worldskills.emparejapp.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.worldskills.emparejapp.Entidades.listaVo;

import java.util.ArrayList;

public class Crud extends SQLiteOpenHelper {
    public Crud(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_config(id integer primary key autoincrement, minutos text,segundos text,siTiempo integer)");
        ContentValues registro1=new ContentValues();
        for (int i=0;i<12;i++){
            ContentValues registro=new ContentValues();
            registro.put("nombre","nadie");
            registro.put("puntaje","0");
            registro.put("tiempo","00:00");
            db.insert("tb_puntaje",null,registro);
        }
        registro1.put("minutos","0");
        registro1.put("segundos","0");
        registro1.put("siTiempo","0");
        db.insert("tb_config",null,registro1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tb_puntaje");
        db.execSQL("drop table if exists tb_config");
        db.execSQL("create table tb_puntaje(id integer primary key autoincrement,nombre text,puntaje integer,tiempo text)");
        db.execSQL("create table tb_config(id integer primary key autoincrement, minutos text,segundos text,siTiempo integer)");
    }
    public void iniciarDB(Context context){
        Crud crud=new Crud(context,"emparejados",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
    }
    private void modificar(Context context,String table,String Id,ContentValues registro){
        Crud crud=new Crud(context,"emparejados",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        db.update(table,registro,"id="+Id,null);
    }
    ArrayList<listaVo> lista;
    private void consultar(Context context, String table, ArrayList<listaVo> lista){
        this.lista=lista;
        Crud crud=new Crud(context,"emparejados",null,1);
        SQLiteDatabase db=crud.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+table,null);
        while (cursor.moveToNext()){
            lista.add(new listaVo(cursor.getColumnName(1),cursor.getColumnName(2),cursor.getColumnName(3)));
        }
        cursor.close();
    }
}
