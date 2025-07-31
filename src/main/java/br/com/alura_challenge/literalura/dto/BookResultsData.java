package br.com.alura_challenge.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResultsData(
        int count,
        List<BookData> results
) {
}
