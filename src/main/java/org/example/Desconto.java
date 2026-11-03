package org.example;

/**
 * Classe utilitária responsável pelo cálculo de descontos.
 */
public final class Desconto {

    // Evita que alguém crie objetos de uma classe que só possui método estático.
    private Desconto() {
    }

    /**
     * Calcula o preço após aplicar um percentual de desconto.
     *
     * @param preco preço original, maior ou igual a zero
     * @param percentual percentual entre 0 e 100
     * @return preço final depois do desconto
     */
    public static double calcular(double preco, int percentual) {
        // A validação ocorre antes de qualquer cálculo.
        if (preco < 0) {
            throw new IllegalArgumentException(
                    "O preço não pode ser negativo."
            );
        }

        // Zero e cem são valores válidos e representam as fronteiras.
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException(
                    "O percentual deve estar entre 0 e 100."
            );
        }

        // A divisão por 100.0 mantém o cálculo em ponto flutuante.
        double valorDoDesconto = preco * percentual / 100.0;

        return preco - valorDoDesconto;
    }
}