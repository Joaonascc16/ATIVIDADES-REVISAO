import org.example.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private static final double DELTA = 0.001;

    @Test
    void deveCalcularValorEstoque() {
        // Arrange
        Produto produto = new Produto("Caneta", 25.0, 4);

        // Act
        double resultado = produto.calcularValorEstoque();

        // Assert
        assertEquals(100.0, resultado, DELTA);
    }

    @Test
    void deveCalcularPrecoComDesconto() {
        // Arrange
        Produto produto = new Produto("Mochila", 80.0, 10);

        // Act
        double resultado = produto.calcularPrecoComDesconto(25);

        // Assert
        assertEquals(60.0, resultado, DELTA);
    }

    @Test
    void naoDeveAlterarPrecoOriginalAoCalcularDesconto() {
        // Arrange
        Produto produto = new Produto("Mochila", 80.0, 10);

        // Act
        produto.calcularPrecoComDesconto(25);

        // Assert
        assertEquals(80.0, produto.getPreco(), DELTA);
    }

    @Test
    void deveRejeitarNomeNulo() {
        // Arrange + Act + Assert
        assertThrows(IllegalArgumentException.class,
                () -> new Produto(null, 10.0, 1));
    }

    @Test
    void deveRejeitarNomeEmBranco() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("   ", 10.0, 1));
    }

    @Test
    void deveRejeitarPrecoZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Caneta", 0, 1));
    }

    @Test
    void deveRejeitarPrecoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Caneta", -5.0, 1));
    }

    @Test
    void deveRejeitarQuantidadeNegativa() {
        assertThrows(IllegalArgumentException.class,
                () -> new Produto("Caneta", 10.0, -1));
    }

    @Test
    void deveRejeitarDescontoForaDoIntervalo() {
        // Arrange
        Produto produto = new Produto("Caneta", 10.0, 1);

        // Act + Assert
        assertThrows(IllegalArgumentException.class,
                () -> produto.calcularPrecoComDesconto(-1));
        assertThrows(IllegalArgumentException.class,
                () -> produto.calcularPrecoComDesconto(100.1));
    }

    @Test
    void deveAceitarDescontosNosLimites() {
        // Arrange
        Produto produto = new Produto("Caneta", 10.0, 1);

        // Act + Assert
        assertEquals(10.0, produto.calcularPrecoComDesconto(0), DELTA);
        assertEquals(0.0, produto.calcularPrecoComDesconto(100), DELTA);
    }

    @Test
    void deveVerificarTodosOsDadosDoProduto() {
        // Arrange
        Produto produto = new Produto("Caderno", 12.5, 8);

        // Act
        double valorTotal = produto.calcularValorEstoque();

        // Assert
        assertAll("dados do produto",
                () -> assertEquals("Caderno", produto.getNome()),
                () -> assertEquals(12.5, produto.getPreco(), DELTA),
                () -> assertEquals(8, produto.getQuantidade()),
                () -> assertEquals(100.0, valorTotal, DELTA)
        );
    }
}