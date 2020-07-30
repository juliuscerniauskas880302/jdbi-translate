package com.juliuscerniauskas.visma.translatorjdbi.controller;

import com.juliuscerniauskas.visma.translatorjdbi.model.Translation;
import com.juliuscerniauskas.visma.translatorjdbi.repository.TranslationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private TranslationRepository translationRepository;

    public TranslationController(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @PostMapping("{id}/{language}/{translation}")
    public void createUpdate(
            @PathVariable final Long id,
            @PathVariable String language,
            @PathVariable String translation) {
        translationRepository.createOrUpdate(id, language, translation);
    }

    @GetMapping()
    public List<Translation> getAll() {
        return translationRepository.getAllTranslations();
    }

    @GetMapping("/lan/{language}")
    public List<Translation> getAllTranslationsFor(@PathVariable final String language) {
        return translationRepository.getAllTranslationsFor(language);
    }

    @GetMapping("/word/{id}")
    public List<Translation> getAllTranslationsForWord(@PathVariable final Long id) {
        return translationRepository.getAllTranslationsForWord(id);
    }

}
