package com.example.produtoapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeestoque;

    public Produto(long id, String nome, String descricao, double preco, int quantidadeestoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeestoque = quantidadeestoque;
    }

    public Produto() {

    }

    public Produto(String nome, String descricao, double preco, int quantidadeestoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeestoque = quantidadeestoque;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeestoque;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(int quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidadeestoque=" + quantidadeestoque +
                '}';
    }
}

