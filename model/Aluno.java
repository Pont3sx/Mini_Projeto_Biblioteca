package model;

public class Aluno extends Usuario{
    private String matricula;
    private String curso;

    public Aluno(String nomeUsuario, String email, String matricula, String curso) {
        super(nomeUsuario, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return this.matricula;
    }
    public String getCurso() {
        return this.curso;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 2;
    }
}
