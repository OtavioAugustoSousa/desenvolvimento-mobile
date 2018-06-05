package br.unicatolica.pos.otavio.itstore.model;

import java.io.Serializable;

public class Produto implements Serializable {
    
    private String nome;
    private String preco;
    private String uid;

    public Produto() {

    }

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }
}
