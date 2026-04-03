package service;

import exceptions.LivroIndisponivelException;
import exceptions.LivroNaoEncontradoException;
import model.Aluno;
import model.Livro;
import model.Professor;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    //Arraylist que armazena livros, usuarios e emprestimos
    private ArrayList<Livro> listaLivros;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Emprestimo> listaEmprestimos;

    public Biblioteca(){
        this.listaLivros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.listaEmprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(String titulo, String autor) {
        Livro novoLivro = new Livro(titulo, autor);
        listaLivros.add(novoLivro);
    }

    public void cadastrarAluno(String nomeUsuario, String email, String matricula, String curso) {
        Aluno novoAluno = new Aluno(nomeUsuario, email, matricula, curso);
        listaUsuarios.add(novoAluno);
    }

    public void cadastrarProfessor(String nomeUsuario, String email, String registro, String departamento) {
        Professor novoProfessor = new Professor(nomeUsuario, email, registro, departamento);
        listaUsuarios.add(novoProfessor);
    }

    public void listarLivros() {
        System.out.println("Lista de Livros Disponível: ");

        if (listaLivros.isEmpty()) {
            System.out.println("Nenhum livro está disponível no momento :(");
            return;
        }

        for (Livro livro : listaLivros) {
            livro.exibirLivro();
            System.out.print("\n");
        }
    }

    //Busca o livro por titulo
    //Verifica se titulo não é null e depois faz a comparação
    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null) return null;

        for (Livro livro : listaLivros) {
            if (livro.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                return livro;
            }
        }
        return null;
    }

    //Busca os livros por autor
    //Verifica se autor não é null, depois faz a comparação e adiciona os livros na lista e retorna ela
    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> encontrados = new ArrayList<>();

        if (autor == null) return encontrados;

        for (Livro livro : listaLivros) {
            if ((livro.getAutor().equalsIgnoreCase(autor))) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }


    public void emprestarLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);

        //Verifica se o livro existe
        if (livro == null) {
            throw new LivroNaoEncontradoException("Livro não encontrado.");
        }

        //Verifica se o livro está disponível
        if (!livro.getDisponivel()) {
            throw new LivroIndisponivelException("Livro já está emprestado.");
        }

        //Empresta o livro
        livro.setDisponivel(false);
        System.out.println("Empréstimo do livro '" + livro.getTitulo() + "' realizado com sucesso.");
    }

    public void devolverLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);

        //Verifica se o livro existe
        if (livro == null) {
            throw new LivroNaoEncontradoException("Livro não encontrado.");
        }

        //Verifica se o livro está disponível
        if (livro.getDisponivel()) {
            throw new IllegalStateException("Livro já foi devolvido e está disponível.");
        }

        //Devolve o livro
        livro.setDisponivel(true);
        System.out.println("Livro '" + livro.getTitulo() + "' devolvido com sucesso.");
    }
}
