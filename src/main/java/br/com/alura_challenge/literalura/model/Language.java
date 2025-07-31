package br.com.alura_challenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String code;

    @ManyToMany(mappedBy = "languages")
    private List<Book> books = new ArrayList<>();

    public Language() {}

    public Language(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String acronyms) {
        this.code = acronyms;
    }

    public List<Book> getBooks() { return books; }

    public void setBooks(List<Book> books) { this.books = books; }
}