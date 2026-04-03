package app;

import exceptions.LivroIndisponivelException;
import exceptions.LivroNaoEncontradoException;
import service.Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean sitemaEmExecucao = true;

        Scanner leitorInput = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("Bem-vindo a Mini Biblioteca \uD83D\uDCD6");
        while (sitemaEmExecucao) {
            System.out.println("===== MENU MINI BIBLIOTECA =====");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Aluno");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Listar Livros Disponíveis na Biblioteca");
            System.out.println("5 - Realizar Emprestimo");
            System.out.println("6 - Devolver Livro");
            System.out.print("Digite um número: ");

            int numeroMenu = leitorInput.nextInt();
            leitorInput.nextLine();
            switch (numeroMenu) {
                case 0:
                    System.out.println("Encerrando Sitema...");
                    sitemaEmExecucao = false;
                    break;
                case 1:
                    System.out.print("Digite o Nome do(a) Professor(a) para Fazer o Cadastro: ");
                    String nomeProfessor = leitorInput.nextLine();

                    System.out.print("Digite o Email do(a) Professor(a): ");
                    String emailProfessor = leitorInput.nextLine();

                    System.out.print("Digite o Registro de Identificação do(a) Professor(a): ");
                    String registro = leitorInput.nextLine();

                    System.out.print("Digite o Departamneto do(a) Professor(a): ");
                    String departamento = leitorInput.nextLine();

                    biblioteca.cadastrarProfessor(nomeProfessor, emailProfessor, registro, departamento);
                    break;
                case 2:
                    System.out.print("Digite o Nome do(a) Aluno(a) para Fazer o Cadastro: ");
                    String nomeAluno = leitorInput.nextLine();

                    System.out.print("Digite o Email do(a) Aluno(a): ");
                    String emailAluno = leitorInput.nextLine();

                    System.out.print("Digite a Matrícula do(a) Aluno(a): ");
                    String matricula = leitorInput.nextLine();

                    System.out.print("Digite o Curso do(a) Aluno(a): ");
                    String curso = leitorInput.nextLine();

                    biblioteca.cadastrarAluno(nomeAluno, emailAluno, matricula, curso);
                    break;
                case 3:
                    System.out.print("Digite o Titulo do Livro para Fazer o Cadastro: ");
                    String titulo = leitorInput.nextLine();

                    System.out.print("Digite o Autor do Livro: ");
                    String autor = leitorInput.nextLine();

                    biblioteca.cadastrarLivro(titulo, autor);
                    break;
                case 4:
                    biblioteca.listarLivros();
                    break;
                case 5:
                    System.out.print("Digite o Título do Livro para fazer seu Empréstimo: ");
                    String tituloLivro = leitorInput.nextLine();

                    try {
                        biblioteca.emprestarLivro(tituloLivro);
                    } catch (LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    } catch (LivroIndisponivelException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Digite o Título do Livro para fazer sua Devolução: ");
                    String tituloDevolucao = leitorInput.nextLine();

                    try {
                        biblioteca.devolverLivro(tituloDevolucao);
                    } catch (LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inexistente! Digite outro número.");
            }
        }
    }
}
