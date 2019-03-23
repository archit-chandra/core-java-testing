package com.example.regisalternative.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.regisalternative.model.RegisAlternative;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.util.StringUtils;

public class ConversionTest {

    private List<RegisAlternative> regisAlternatives;

    public void init() {
        fillRegisAlternatives();
        printRegisAlternativeList();


    }

    public String convertToJson(List<RegisAlternative> regisAlternatives) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(regisAlternatives);
    }

    private void printRegisAlternativeList() {
        System.out.println(regisAlternatives);
        System.out.println("-------------------------------------------------------");
        for (RegisAlternative regisAlternative : regisAlternatives) {
            System.out.println(regisAlternative);
            System.out.println("-----------");
        }
    }

    private void fillRegisAlternatives() {
        regisAlternatives = new ArrayList<>();
        List<String> values = Arrays.asList("guardian", "guarantor");
        for (String value : values) {
            Map<String, String> translations = new HashMap<>();
            List<String> languageCodes = Arrays.asList("en", "nb");
            for (String languageCode : languageCodes) {
                translations.put(languageCode, getTranslation(languageCode, value));
            }
            RegisAlternative regisAlternative = new RegisAlternative(value, translations);
            regisAlternatives.add(regisAlternative);
        }

    }

    private String getTranslation(String languageCode, String value) {
        return "[" + languageCode + "]" + StringUtils.capitalize(value);
    }

    public List<RegisAlternative> getRegisAlternatives() {
        return regisAlternatives;
    }

    public List<RegisAlternative> converToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, List.class);
    }
}
