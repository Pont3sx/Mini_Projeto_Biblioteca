package model;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    //Construtor
    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    //Método
    public void exibirLivro() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);

        if (disponivel) {
            System.out.println("Status: Disponível");
        } else {
            System.out.println("Status: Emprestado");
        }
    }
}
