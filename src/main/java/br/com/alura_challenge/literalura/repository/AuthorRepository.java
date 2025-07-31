package br.com.alura_challenge.literalura.repository;

import br.com.alura_challenge.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByName(String name);
    @Query("SELECT a FROM Author a WHERE a.birthYear >= :year AND a.deathYear <= :year")
    List<Author> findAuthorsAliveInYear(String year);
}
