import org.example.Livro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LivroTest {

    // Atributo que vai guardar o objeto usado em cada audiência (teste)
    private Livro livro;

    @BeforeEach
    void configurarCadaTeste() {
        // Executa ANTES de cada @Test: cria um Livro "fresco" para cada audiência,
        // garantindo que um teste não interfira no outro
        livro = new Livro("Clean Code", "Robert C. Martin");
        System.out.println("[BeforeEach] Livro criado para o teste.");
    }

    @AfterEach
    void encerrarCadaTeste() {
        // Executa DEPOIS de cada @Test: aqui poderíamos, por exemplo,
        // "descartar" recursos usados no teste (não há nada a limpar neste caso simples)
        System.out.println("[AfterEach] Teste finalizado.");
    }

    @Test
    void livroDeveNascerDisponivel() {
        // Verifica se um livro recém-criado começa como NÃO emprestado
        assertFalse(livro.isEmprestado());
    }

    @Test
    void emprestarDeveMarcarLivroComoEmprestado() {
        livro.emprestar();
        assertTrue(livro.isEmprestado());
    }

    @Test
    void devolverAposEmprestimoDeveLiberarLivro() {
        livro.emprestar();
        livro.devolver();
        assertFalse(livro.isEmprestado());
    }
}