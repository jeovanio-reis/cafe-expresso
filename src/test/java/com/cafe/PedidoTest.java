package com.cafe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    void deveIniciarComStatusPendente() {
        Pedido pedido = new Pedido();
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
    }

    @Test
    void deveIniciarSemItens() {
        Pedido pedido = new Pedido();
        assertEquals(0, pedido.getItens().size());
    }

    @Test
    void deveAdicionarItemAoPedido() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Cafe", 5.0);
        pedido.adicionarItem(produto, 2);
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveCalcularTotalDoPedido() {
        Pedido pedido = new Pedido();
        Produto cafe = new Produto("Cafe", 5.0);
        Produto pao = new Produto("Pao", 3.0);
        pedido.adicionarItem(cafe, 2);
        pedido.adicionarItem(pao, 1);
        assertEquals(13.0, pedido.calcularTotal());
    }

    @Test
    void devePagarPedido() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Cafe", 5.0);
        pedido.adicionarItem(produto, 1);
        pedido.pagar();
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void deveLancarExcecaoAoPagarPedidoVazio() {
        Pedido pedido = new Pedido();
        try {
            pedido.pagar();
            fail("Deveria ter lancado excecao");
        } catch (IllegalStateException e) {
            assertEquals("Nao e possivel pagar pedido sem itens.", e.getMessage());
        }
    }

    @Test
    void deveEnviarParaCozinhaAposPagar() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Cafe", 5.0);
        pedido.adicionarItem(produto, 1);
        pedido.pagar();
        pedido.enviarParaCozinha();
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());
    }

    @Test
    void deveFinalizarPedido() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Cafe", 5.0);
        pedido.adicionarItem(produto, 1);
        pedido.pagar();
        pedido.enviarParaCozinha();
        pedido.finalizarPedido();
        assertEquals(StatusPedido.FINALIZADO, pedido.getStatus());
    }

    @Test
    void naoDeveAdicionarItemAposPagar() {
        Pedido pedido = new Pedido();
        Produto produto = new Produto("Cafe", 5.0);
        pedido.adicionarItem(produto, 1);
        pedido.pagar();
        try {
            pedido.adicionarItem(produto, 1);
            fail("Deveria ter lancado excecao");
        } catch (IllegalStateException e) {
            assertEquals("Itens so podem ser adicionados com pedido PENDENTE.", e.getMessage());
        }
    }
}