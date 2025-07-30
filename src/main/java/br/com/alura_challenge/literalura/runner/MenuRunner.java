package br.com.alura_challenge.literalura.runner;

import java.util.Scanner;

public class MenuRunner {
    private final Scanner leitura = new Scanner(System.in);

    public void showMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    -----------------------------------------------
                    1 - Buscar livro pelo título
                    2 - Buscar livros registrados
                    3 - Listar autores registrados
                    4 - Buscar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    -----------------------------------------------
                    0 - Sair
                    -----------------------------------------------
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    //searchBookByTitle();
                    break;
                case 2:
                    //searchRegisteredBooks();
                    break;
                case 3:
                    //listRegisteredAuthors();
                    break;
                case 4:
                    //searchLivingAuthorsByYear();
                    break;
                case 5:
                    //searchBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
