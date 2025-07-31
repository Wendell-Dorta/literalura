package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.dto.AuthorData;
import br.com.alura_challenge.literalura.model.Author;
import br.com.alura_challenge.literalura.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final GutendexApiHelper helper;
    private final AuthorRepository repository;

    public AuthorService(GutendexApiHelper helper, AuthorRepository repository) {
        this.helper = helper;
        this.repository = repository;
    }

    @Transactional
    public List<Author> findAndSaveAuthors(List<AuthorData> authorDataList) {
        // 1. Encontra ou cria os objetos em memória
        List<Author> authors = authorDataList.stream()
                .map(data -> repository.findByName(data.name())
                        .orElseGet(() -> new Author(data.name(), data.birthYear(), data.deathYear())))
                .collect(Collectors.toList());

        return repository.saveAll(authors);
    }

    public void listRegisteredAuthors() {
        List<Author> authors = repository.findAllWithBooks();
        if (authors.isEmpty()) {
            System.out.println("Nenhum autor registrado no banco de dados.");
        } else {
            authors.forEach(System.out::println);
        }
    }

    public void findLivingAuthorsInYear(Integer year) {
        List<Author> authors = repository.findAuthorsAliveInYear(year);
        if (authors.isEmpty()) {
            System.out.println("Nenhum autor vivo neste ano.");
        } else {
            authors.forEach(System.out::println);
        }
    }
}