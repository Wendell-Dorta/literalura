package br.com.alura_challenge.literalura.repository;

import br.com.alura_challenge.literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}

