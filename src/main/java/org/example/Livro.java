package org.example;

public class Livro {

    private String titulo;
    private String autor;
    private boolean emprestado;

    // Construtor: todo livro nasce disponível (não emprestado)
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    // Regra de negócio: só posso emprestar um livro que não está emprestado
    public void emprestar() {
        if (this.emprestado) {
            throw new IllegalStateException("Este livro já está emprestado.");
        }
        this.emprestado = true;
    }

    // Regra de negócio: só posso devolver um livro que está emprestado
    public void devolver() {
        if (!this.emprestado) {
            throw new IllegalStateException("Este livro não está emprestado.");
        }
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }
}
