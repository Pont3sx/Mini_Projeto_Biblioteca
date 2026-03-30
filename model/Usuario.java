package model;

public abstract class Usuario {
    private String nomeUsuario;
    private String email;

    //Construtor
    public Usuario(String nomeUsuario, String email) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }
    public String getEmail() {
        return this.email;
    }

    public abstract int getLimiteEmprestimos();
}