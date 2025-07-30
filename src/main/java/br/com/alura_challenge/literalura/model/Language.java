package br.com.alura_challenge.literalura.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

public class Language {
    private Integer id;
    private String acronyms;
    @ManyToMany(mappedBy = "languages", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcronyms() {
        return acronyms;
    }

    public void setAcronyms(String acronyms) {
        this.acronyms = acronyms;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;

        for (Book book : books) {
            if (!book.getLanguages().contains(this)) {
                book.getLanguages().add(this);
            }
        }
    }
}
