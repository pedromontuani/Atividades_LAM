package com.example.alunos.listadinamica.model;

public class Pessoa {
    private String nome, telefone;
    private int imagem;

    public Pessoa(String nome, String telefone, int idImagem){
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = idImagem;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public int getImagem(){
        return imagem;
    }

    public void setImagem(int id){
        this.imagem = id;
    }
}
