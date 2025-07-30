package br.com.alura_challenge.literalura.model;

import java.util.List;

public class Book {
    private Integer id;
    private String title;
    private List<Author> authors;
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
    }

    public List<Language> getLanguage() {
        return languages;
    }

    public void setLanguage(List<Language> languages) {
        this.languages = languages;
    }

    public Double getDownloadsNumber() {
        return downloadsNumber;
    }

    public void setDownloadsNumber(Double downloadsNumber) {
        this.downloadsNumber = downloadsNumber;
    }
}