import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ItemPedidoTest {

    @Test
    void deveCalcularSubtotalCorretamente() {
        Produto produto = new Produto("Café", 5.0);
        ItemPedido item = new ItemPedido(produto, 2);

        assertEquals(10.0, item.calcularSubtotal());
    }
}
