package com.juliuscerniauskas.visma.translatorjdbi.repository;

import com.juliuscerniauskas.visma.translatorjdbi.model.Translation;
import com.juliuscerniauskas.visma.translatorjdbi.model.mapper.TranslationMapper;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TranslationRepositoryImpl implements TranslationRepository {

    private Jdbi jdbi;

    public TranslationRepositoryImpl(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Override
    public List<Translation> getAllTranslations() {
        return jdbi.withHandle(handle -> handle
                .registerRowMapper(new TranslationMapper())
                .createQuery("SELECT * FROM translations")
                .mapTo(Translation.class)
                .list());
    }

    @Override
    public List<Translation> getAllTranslationsFor(String language) {
        return jdbi.withHandle(handle -> handle
                .registerRowMapper(new TranslationMapper())
                .createQuery("SELECT * FROM translations WHERE language = ?")
                .bind(0, language)
                .mapTo(Translation.class)
                .list());
    }

    @Override
    public List<Translation> getAllTranslationsForWord(Long wordId) {
        return jdbi.withHandle(handle -> handle
                .registerRowMapper(new TranslationMapper())
                .createQuery("SELECT * FROM translations WHERE text_id = ?")
                .bind(0, wordId)
                .mapTo(Translation.class)
                .list());
    }

    @Override
    public Translation getTranslationForWordIn(Long wordId, String language) {
        return null;
    }

    @Override
    public Translation createOrUpdate(Long wordId, String language, String translation) {
        Optional<Translation> optional = jdbi.withHandle(handle -> handle
                .registerRowMapper(new TranslationMapper())
                .createQuery("SELECT * FROM translations WHERE text_id = ? AND language = ?")
                .bind(0, wordId)
                .bind(1, language)
                .mapTo(Translation.class)
                .findOne());

        Long wordIdToReturn;

        if (!optional.isPresent()) {
            wordIdToReturn = jdbi.withHandle(handle -> handle
//                    .registerRowMapper(new TranslationMapper())
                    .createUpdate("INSERT INTO translations (text_id, language, translation) values (?, ?, ?)")
                    .bind(0, wordId)
                    .bind(1, language)
                    .bind(2, translation)
                    .executeAndReturnGeneratedKeys("id")
                    .mapTo(Long.class)
                    .one());
            System.out.println(wordIdToReturn);
        } else {
            List<Long> id = jdbi.withHandle(handle -> handle
                    .createUpdate("UPDATE translations set translation = ? WHERE text_id = ? AND language = ?")
                    .bind(0, translation)
                    .bind(1, wordId)
                    .bind(2, language)
                    .executeAndReturnGeneratedKeys("id")
                    .mapTo(Long.class)
                    .list());
            System.out.println(id);
        }

        Optional<Translation> updatedTranslation =
                jdbi.withHandle(handle -> handle
                        .registerRowMapper(new TranslationMapper())
                        .createQuery("SELECT * FROM translations WHERE id = ?"))
                        .bind(0, 1)
                        .mapTo(Translation.class)
                        .findOne();

        return updatedTranslation.orElse(null);
    }

}
