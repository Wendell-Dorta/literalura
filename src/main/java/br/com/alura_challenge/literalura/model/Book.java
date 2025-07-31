package br.com.alura_challenge.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();
    private Integer downloadsNumber;

    public  Book() {}

    public  Book(String title, List<Author> authors, List<Language> languages, Integer downloadsNumber) {
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.downloadsNumber = downloadsNumber;
    }

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

    public List<Author> getAuthor() { return authors; }

    public void setAuthor(List<Author> authors) {
        this.authors = authors;
    }

    public List<Language> getLanguages() { return languages; }

    public void setLanguage(List<Language> languages) {
        this.languages = languages;
    }

    public Integer getDownloadsNumber() {
        return downloadsNumber;
    }

    public void setDownloadsNumber(Integer downloadsNumber) {
        this.downloadsNumber = downloadsNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-----------------------------------------------------------------\n");
        sb.append("Título: ").append(this.title).append("\n");

        sb.append("Autor: ");
        if (authors != null && !authors.isEmpty()) {
            String authorsStr = authors.stream()
                    .map(author -> author.getName())
                    .collect(Collectors.joining(", "));
            sb.append(authorsStr);
        } else {
            sb.append("Nenhum autor");
        }
        sb.append("\n");

        sb.append("Idiomas: ");
        if (languages != null && !languages.isEmpty()) {
            String languagesStr = languages.stream()
                    .map(language -> language.getCode())
                    .collect(Collectors.joining(", "));
            sb.append(languagesStr);
        } else {
            sb.append("Nenhum idioma");
        }
        sb.append("\n");

        sb.append("Número de Downloads: ").append(this.downloadsNumber).append("\n");
        sb.append("-----------------------------------------------------------------");

        return sb.toString();
    }
}