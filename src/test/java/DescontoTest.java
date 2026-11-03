import org.example.Desconto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DescontoTest {

    // Tolerância para comparações com double
    private static final double DELTA = 0.001;

    // @ValueSource: apenas um valor varia entre as execuções (o preço)
    @ParameterizedTest(name = "preço inválido: {0}")
    @ValueSource(doubles = {-0.01, -1.0, -100.0})
    void precoNegativoDeveLancarExcecao(double preco) {
        // Arrange
        int percentual = 10;

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> Desconto.calcular(preco, percentual)
        );

        // Assert
        assertEquals("O preço não pode ser negativo.", excecao.getMessage());
    }

    // @ValueSource com ints: apenas o percentual varia
    @ParameterizedTest(name = "percentual inválido: {0}")
    @ValueSource(ints = {-1, -50, 101, 200})
    void percentualForaDoIntervaloDeveLancarExcecao(int percentual) {
        // Arrange
        double preco = 100.0;

        // Act
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> Desconto.calcular(preco, percentual)
        );

        // Assert
        assertEquals("O percentual deve estar entre 0 e 100.", excecao.getMessage());
    }

    // @CsvSource: três argumentos por execução (preço, percentual, esperado)
    @ParameterizedTest(name = "caso {index}: R$ {0} - {1}% deve resultar em R$ {2}")
    @CsvSource({
            "100.00, 10, 90.00",
            "200.00, 25, 150.00",
            "80.00, 0, 80.00",
            "50.00, 100, 0.00",
            "0.00, 50, 0.00"
    })
    void calcularDeveAplicarPercentual(double preco, int percentual, double esperado) {
        // Arrange: os dados chegam pelos parâmetros

        // Act
        double resultado = Desconto.calcular(preco, percentual);

        // Assert
        assertEquals(esperado, resultado, DELTA);
    }
}