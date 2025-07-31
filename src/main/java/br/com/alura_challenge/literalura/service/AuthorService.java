package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.model.Author;
import br.com.alura_challenge.literalura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {
    private final CommonServiceHelper helper;

    public AuthorService(CommonServiceHelper helper) {
        this.helper = helper;
    }

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    public void listRegisteredAuthors() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }
}