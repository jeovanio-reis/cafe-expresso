import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    void deveCriarProdutoCorretamente() {
        Produto produto = new Produto("Café", 5.0);

        assertEquals("Café", produto.getNome());
        assertEquals(5.0, produto.getPreco());
    }
}