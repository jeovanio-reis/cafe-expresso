package com.cafe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ItemPedidoTest {

    @Test
    void deveCalcularSubtotalCorretamente() {
        Produto produto = new Produto("Cafe", 5.0);
        ItemPedido item = new ItemPedido(produto, 2);
        double resultado = item.calcularSubtotal();
        assertEquals(10.0, resultado);
    }

    @Test
    void deveLancarExcecaoParaProdutoNulo() {
        try {
            new ItemPedido(null, 1);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Produto nao pode ser nulo.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoParaQuantidadeZero() {
        Produto produto = new Produto("Cafe", 5.0);
        try {
            new ItemPedido(produto, 0);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade deve ser maior que zero.", e.getMessage());
        }
    }

    @Test
    void deveLancarExcecaoParaQuantidadeNegativa() {
        Produto produto = new Produto("Cafe", 5.0);
        try {
            new ItemPedido(produto, -1);
            fail("Deveria ter lancado excecao");
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade deve ser maior que zero.", e.getMessage());
        }
    }

    @Test
    void deveRetornarProdutoCorreto() {
        Produto produto = new Produto("Cha", 4.0);
        ItemPedido item = new ItemPedido(produto, 3);
        assertEquals(produto, item.getProduto());
    }

    @Test
    void deveRetornarQuantidadeCorreta() {
        Produto produto = new Produto("Cafe", 5.0);
        ItemPedido item = new ItemPedido(produto, 3);
        assertEquals(3, item.getQuantidade());
    }
}
