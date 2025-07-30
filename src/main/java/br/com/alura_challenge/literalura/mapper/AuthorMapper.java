package br.com.alura_challenge.literalura.mapper;

import br.com.alura_challenge.literalura.dto.AuthorData;
import br.com.alura_challenge.literalura.model.Author;

public class AuthorMapper {
    public static Author toEntity(AuthorData data) {
        return new Author(data.name(), data.birthYear(), data.deathYear());
    }
}

