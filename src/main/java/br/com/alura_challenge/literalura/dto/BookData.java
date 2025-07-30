package br.com.alura_challenge.literalura.dto;

import br.com.alura_challenge.literalura.model.Author;
import br.com.alura_challenge.literalura.model.Language;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title")String title,
        @JsonAlias("authors")List<AuthorData> authors,
        @JsonAlias("languages")List<String> languages,
        @JsonAlias("download_count")Integer downloadsNumber
) {
}
