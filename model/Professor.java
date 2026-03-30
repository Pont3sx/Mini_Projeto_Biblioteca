package model;

public class Professor extends Usuario{
    private String registro;
    private String departamento;

    public Professor(String nomeUsuario, String email, String registro, String departamento) {
        super(nomeUsuario, email);
        this.registro = registro;
        this.departamento = departamento;
    }

    public String getRegistro() {
        return this.registro;
    }
    public String getDepartamento() {
        return this.departamento;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }
}
