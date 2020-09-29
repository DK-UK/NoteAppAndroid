package com.example.noteapp.models;

public class nota {
    private int _id;
    private String titulo;
    private String contenido;

    @Override
    public String toString() {
        return "nota{" +
                "_id=" + _id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }

    public nota() {
    }

    public nota(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public nota(int _id, String titulo, String contenido) {
        this._id = _id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
