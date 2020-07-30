package com.juliuscerniauskas.visma.translatorjdbi.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Translation {

    @ColumnName("id")
    private Long id;

    @ColumnName("text_id")
    private Long textId;

    @ColumnName("language")
    private String languageCode;

    @ColumnName("translation")
    private String translation;

    public Translation(Long id, Long textId, String languageCode, String translation) {
        this.id = id;
        this.textId = textId;
        this.languageCode = languageCode;
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTextId() {
        return textId;
    }

    public void setTextId(Long textId) {
        this.textId = textId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
