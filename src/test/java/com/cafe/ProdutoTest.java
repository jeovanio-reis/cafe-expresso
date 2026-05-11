package com.cafe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    void deveCriarProdutoCorretamente() {
        Produto produto = new Produto("Cafe", 5.0);
        assertEquals("Cafe", produto.getNome());
        assertEquals(5.0, produto.getPreco());
    }

    @Test
    void deveLancarExcecaoParaNomeVazio() {
        try {
            new Produto("", 5.0);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome nao pode ser vazio.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoParaNomeNulo() {
        try {
            new Produto(null, 5.0);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome nao pode ser vazio.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoParaPrecoZero() {
        try {
            new Produto("Cafe", 0);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Preco deve ser maior que zero.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoParaPrecoNegativo() {
        try {
            new Produto("Cafe", -1.0);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Preco deve ser maior que zero.", e.getMessage());
        }
    }
}