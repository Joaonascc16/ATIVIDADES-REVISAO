
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    private static List<String> livros;

    @BeforeAll
    static void prepararBiblioteca() {
        livros = new ArrayList<>();
        livros.add("Dom Casmurro");
        livros.add("O Pequeno Príncipe");
        livros.add("1984");

        System.out.println("Biblioteca preparada");
    }

    @Test
    void deveConterTresLivros() {
        assertEquals(3, livros.size());
    }

    @Test
    void deveConter1984() {
        assertTrue(livros.contains("1984"));
    }

    @Test
    void naoDeveConterLivroInexistente() {
        assertFalse(livros.contains("Livro inexistente"));
    }

    @AfterAll
    static void encerrarBiblioteca() {
        livros.clear();

        System.out.println("Biblioteca encerrada");
    }
}