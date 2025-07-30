package br.com.alura_challenge.literalura.repository;

import br.com.alura_challenge.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
