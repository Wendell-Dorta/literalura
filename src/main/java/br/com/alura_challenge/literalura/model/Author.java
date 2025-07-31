package br.com.alura_challenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;
    private String birthYear;
    private String deathYear;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    public Author() {}

    public Author(String name, String birthYear, String deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birth_year) {
        this.birthYear = birth_year;
    }

    public String getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(String death_year) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) { this.books = books; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-----------------------------------------------------------------\n");
        sb.append("Autor: ").append(this.name).append("\n");
        sb.append("Ano de Nascimento: ").append(this.birthYear).append("\n");
        sb.append("Ano de Falecimento: ").append(this.deathYear).append("\n");

        if (books == null || books.isEmpty()) {
            sb.append("Livros: Nenhum livro cadastrado\n");
        } else {
            String livros = books.stream()
                    .map(Book::getTitle)
                    .collect(Collectors.joining(", "));
            String label = books.size() == 1 ? "Livro" : "Livros";
            sb.append(label).append(": ").append(livros).append("\n");
        }

        sb.append("\n-----------------------------------------------------------------\n");

        return sb.toString();
    }
}
