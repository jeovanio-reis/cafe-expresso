import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    void deveAdicionarItemAoPedido() {
        Pedido pedido = new Pedido();

        Produto produto = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(produto, 2);

        pedido.adicionarItem(item);

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveCalcularTotalDoPedido() {
        Pedido pedido = new Pedido();

        Produto cafe = new Produto("Café", 5.0);
        Produto pao = new Produto("Pão", 3.0);

        pedido.adicionarItem(new ItemPedido(cafe, 2)); // 10
        pedido.adicionarItem(new ItemPedido(pao, 1));  // 3

        assertEquals(13.0, pedido.calcularTotal());
    }

    @Test
    void deveIniciarComStatusPendente() {
        Pedido pedido = new Pedido();

        assertEquals("Pendente", pedido.getStatus());
    }
}
