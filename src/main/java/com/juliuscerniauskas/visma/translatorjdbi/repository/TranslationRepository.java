package com.juliuscerniauskas.visma.translatorjdbi.repository;

import com.juliuscerniauskas.visma.translatorjdbi.model.Translation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository {
    List<Translation> getAllTranslations();
    List<Translation> getAllTranslationsFor(String language);
    List<Translation> getAllTranslationsForWord(Long wordId);
    Translation getTranslationForWordIn(Long wordId, String language);
    Translation createOrUpdate(Long wordId, String language, String translation);
}
