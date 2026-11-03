package org.example;

public class Produto {

    private final String nome;
    private final double preco;
    private final int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser nulo nem em branco.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double calcularValorEstoque() {
        return preco * quantidade;
    }

    public double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("O percentual deve estar entre 0 e 100.");
        }
        return preco - (preco * percentual / 100);
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
}
