package br.com.alura_challenge.literalura.runner;

import br.com.alura_challenge.literalura.service.AuthorService;
import br.com.alura_challenge.literalura.service.BookService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuRunner {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;
    private final AuthorService authorService;

    public MenuRunner(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

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

            System.out.println("\n" + menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    serchBookByTitle();
                    break;
                case 2:
                    bookService.listAllBooks();
                    break;
                case 3:
                    authorService.listRegisteredAuthors();
                    break;
                case 4:
                    searchLivingAuthorsByYear();
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

    private void  serchBookByTitle() {
        System.out.println("Qual o livro que deseja buscar?");
        String bookName = scanner.nextLine();
        bookService.searchBooksWeb(bookName);
    }

    private void searchLivingAuthorsByYear() {
        System.out.println("VocÊ que ver autores vivos em qual ano?");
        Integer year = scanner.nextInt();
        scanner.nextLine();
        authorService.findLivingAuthorsInYear(year);
    }
}