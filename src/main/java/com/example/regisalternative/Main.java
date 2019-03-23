package com.example.regisalternative;

import java.io.IOException;
import java.util.List;

import com.example.regisalternative.model.RegisAlternative;
import com.example.regisalternative.service.ConversionTest;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {

    public static void main(String[] args) {
        ConversionTest test = new ConversionTest();
        test.init();

        // convert to JSON
        String json = null;
        try {
            json = test.convertToJson(test.getRegisAlternatives());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("============================JSON===============================");
        System.out.println(json);


        // convert to Java object again
        List<RegisAlternative> regisAlternatives = null;
        try {
            regisAlternatives = test.converToObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("============================POJO===============================");
        System.out.println(regisAlternatives);


    }
}
