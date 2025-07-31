package br.com.alura_challenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birth_year;
    private String death_year;
    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books = new ArrayList<>();

    public Author() {}

    public Author(String name, String birth_year, String death_year) {
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
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
        return birth_year;
    }

    public void setBirthYear(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getDeathYear() {
        return death_year;
    }

    public void setDeathYear(String death_year) {
        this.death_year = death_year;
    }

    public List<Book> getBooks() {
        if (books == null) {
            books = new ArrayList<>();
        }
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        for (Book book : books) {
            if (!book.getAuthor().contains(this)) {
                book.getAuthor().add(this);
            }
        }
    }
}
