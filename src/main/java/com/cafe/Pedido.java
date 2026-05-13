package com.cafe;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<ItemPedido> itens;
    private StatusPedido status;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Itens so podem ser adicionados com pedido PENDENTE.");
        }
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void pagar() {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("So e possivel pagar um pedido PENDENTE.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Nao e possivel pagar pedido sem itens.");
        }
        this.status = StatusPedido.PAGO;
    }

    public void enviarParaCozinha() {
        if (status != StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido precisa estar PAGO para ir a cozinha.");
        }
        this.status = StatusPedido.EM_PREPARO;
    }

    public void finalizarPedido() {
        if (status != StatusPedido.EM_PREPARO) {
            throw new IllegalStateException("Pedido precisa estar EM_PREPARO para ser finalizado.");
        }
        this.status = StatusPedido.FINALIZADO;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}