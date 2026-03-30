package service;

import model.Livro;
import model.Usuario;
import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
    }

    public Livro getLivro() {
        return this.livro;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
}
