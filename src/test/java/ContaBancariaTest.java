
import org.example.ContaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void criarConta() {
        // Executa antes de CADA @Test: sempre uma conta nova, com R$ 100,00
        conta = new ContaBancaria("João");
    }

    @Test
    void deveIniciarComSaldoDeCem() {
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveDepositarCinquentaReais() {
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacarTrintaReais() {
        conta.sacar(30.0);
        assertEquals(70.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveSacarMaisQueOSaldo() {
        assertThrows(IllegalStateException.class, () -> conta.sacar(200.0));
        // O saldo não pode ter mudado após a falha
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }
    @Test
    void naoDeveDepositarValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveSacarValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(-10));
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }
}