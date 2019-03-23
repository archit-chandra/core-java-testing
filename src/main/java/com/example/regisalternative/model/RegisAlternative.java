package com.example.regisalternative.model;

import java.io.Serializable;
import java.util.Map;

public class RegisAlternative implements Serializable {
    private static final long serialVersionUID = 1L;

    private String value;
    private Map<String, String> translations;

    public RegisAlternative(String value, Map<String, String> translations) {
        this.value = value;
        this.translations = translations;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public void setTranslations(Map<String, String> translations) {
        this.translations = translations;
    }

    @Override
    public String toString() {
        return "RegisAlternative{" +
                "value='" + value + '\'' +
                ", translations=" + translations +
                '}';
    }
}
