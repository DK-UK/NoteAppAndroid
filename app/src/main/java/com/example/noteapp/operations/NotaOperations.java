package com.example.noteapp.operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import com.example.noteapp.database.SQLHelper;
import com.example.noteapp.models.nota;

import java.util.ArrayList;

public class NotaOperations {
    private final Context Context;
    private String DBNAME = "notasapp.db";
    private int VERSION = 3;
    private SQLiteDatabase database;
    private SQLHelper helper;
    private nota model;
    private ArrayList<String> list;

    public NotaOperations(Context context) {
        Context = context;
        helper = new SQLHelper(context, DBNAME, null,VERSION);

    }
    protected void openRead(){
        database = helper.getReadableDatabase();
    }
    protected void openWrite(){
        database = helper.getWritableDatabase();
    }

    protected void close(){
        database.close();
    }

    public int insert(nota model){
        openWrite();

        ContentValues content = new ContentValues();
        content.put("titulo", model.getTitulo());
        content.put("contenido", model.getContenido());

        long id = database.insert("nota", null, content);


        close();
        return (int)id;
    }

    public ArrayList<String> list(){
        list = new ArrayList<>();
        openRead();

        Cursor cursor = database.query("nota", null, null, null, null,null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            String titulo, contenido, end;
            int id;
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                contenido = cursor.getString(cursor.getColumnIndex("contenido"));

                end = String.valueOf(id) + " " + titulo + " " + contenido;
                list.add(end);

            } while (cursor.moveToNext());
        }
        else{

        }

        close();
        return list;
    }


}
