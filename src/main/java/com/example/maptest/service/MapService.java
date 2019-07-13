package com.example.maptest.service;

import java.util.List;
import java.util.Map;

public interface MapService {

    Map<String, List<String>> getOriginalMap();

    void iterateAndDeleteOriginalMap(Map<String, List<String>> originalMap);

    void printEntries(Map<String, List<String>> originalMap);
}
