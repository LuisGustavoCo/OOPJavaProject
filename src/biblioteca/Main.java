package biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("\n===== MENU BIBLIOTECA =====");
            System.out.println("1 - Listar Itens");
            System.out.println("2 - Adicionar Livro");
            System.out.println("3 - Adicionar Revista");
            System.out.println("4 - Emprestar Item");
            System.out.println("5 - Devolver Item");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    biblioteca.listarItens();
                    break;
                case 2:
                    System.out.print("Título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.adicionarItem(new Livro(tituloLivro, autor));
                    System.out.println();
                    System.out.println("Livro adicionado!");
                    break;
                case 3:
                    System.out.print("Título da revista: ");
                    String tituloRevista = scanner.nextLine();
                    System.out.print("Editora da revista: ");
                    String editora = scanner.nextLine();
                    biblioteca.adicionarItem(new Revista(tituloRevista, editora));
                    System.out.println();
                    System.out.println("Revista adicionada!");
                    break;
                case 4:
                    System.out.print("Título do item para emprestar: ");
                    String tituloEmprestar = scanner.nextLine();
                    try {
                        biblioteca.emprestarItem(tituloEmprestar);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Título do item para devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    try {
                        biblioteca.devolverItem(tituloDevolver);
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}

