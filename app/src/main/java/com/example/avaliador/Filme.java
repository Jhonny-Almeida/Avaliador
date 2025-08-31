package com.example.avaliador;

public class Filme {

    private String titulo;
    private int capaFilme;
    private String info;

    public Filme(String titulo, int capaFilme, String info){

        this.titulo = titulo;
        this.capaFilme = capaFilme;
        this.info = info;

    }

    public String getTitulo() {
        return titulo;
    }

    public int getCapaFilme() {
        return capaFilme;
    }

    public String getInfo() {
        return info;
    }

    public String toString(){return titulo;}
}


