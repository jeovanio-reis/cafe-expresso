package com.cafe;

public class Main {
    public static void main(String[] args) {
        Produto cafe = new Produto("Café", 5.0);
        System.out.println("Produto: " + cafe.getNome());
        System.out.println("Preço: R$ " + cafe.getPreco());
    }
}