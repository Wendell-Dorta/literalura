package br.com.alura_challenge.literalura.model;

import jakarta.persistence.*;

import java.util.List;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;
    @ManyToMany
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;
    private Double downloadsNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return authors;
    }

    public void setAuthor(List<Author> authors) {
        this.authors = authors;
        for (Author author : authors) {
            if (!author.getBooks().contains(this)) {
                author.getBooks().add(this);
            }
        }
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguage(List<Language> languages) {
        this.languages = languages;
        for (Language language : languages) {
            if (!language.getBooks().contains(this)) {
                language.getBooks().add(this);
            }
        }
    }

    public Double getDownloadsNumber() {
        return downloadsNumber;
    }

    public void setDownloadsNumber(Double downloadsNumber) {
        this.downloadsNumber = downloadsNumber;
    }
}