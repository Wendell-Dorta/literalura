package br.com.alura_challenge.literalura.repository;

import br.com.alura_challenge.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitleIgnoreCase(String title);
}
