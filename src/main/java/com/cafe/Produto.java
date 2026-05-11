package com.cafe;

public class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome nao pode ser vazio.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preco deve ser maior que zero.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}