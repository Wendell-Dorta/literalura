package br.com.alura_challenge.literalura.dto;

import br.com.alura_challenge.literalura.model.Author;
import br.com.alura_challenge.literalura.model.Language;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

public record BookData(
        @JsonAlias("title")String title,
        @JsonAlias("authors")List<AuthorData> authors,
        @JsonAlias("languages")List<String> languages,
        @JsonAlias("download_count")Integer downloadsNumber
) {
}
