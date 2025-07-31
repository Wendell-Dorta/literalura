package br.com.alura_challenge.literalura.service;

import br.com.alura_challenge.literalura.model.Language;
import br.com.alura_challenge.literalura.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageService {
    private final GutendexApiHelper helper;
    private final LanguageRepository repository;

    public LanguageService(GutendexApiHelper helper, LanguageRepository repository) {
        this.helper = helper;
        this.repository = repository;
    }

    @Transactional
    public List<Language> findAndSaveLanguages(List<String> languageCodes) {
        List<Language> languages = languageCodes.stream()
                .map(code -> repository.findByCode(code)
                        .orElseGet(() -> new Language(code)))
                .collect(Collectors.toList());

        return repository.saveAll(languages);
    }

    public void findAllLanguages() {
        List<Language> languages = repository.findAll();
        for (int i = 0; i < languages.size(); i++) {
            System.out.println((i + 1)+ " - " + languages.get(i).getCode());
        }
    }
}