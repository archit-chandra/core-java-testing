package com.example.maptest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class MapServiceImpl implements MapService {

    Logger logger = Logger.getLogger(MapServiceImpl.class.getName());

    @Override
    public Map<String, List<String>> getOriginalMap() {
        Map<String, List<String>> map = new ConcurrentHashMap<>();

        String personId1 = "P1";
        List<String> personId1RequestIds = new CopyOnWriteArrayList<>();
        personId1RequestIds.add("R1P1");
        personId1RequestIds.add("R2P1");
        map.put(personId1, personId1RequestIds);

        String personId2 = "P2";
        List<String> personId2RequestIds = new CopyOnWriteArrayList<>();
        personId2RequestIds.add("R1P2");
        personId2RequestIds.add("R2P2");
        personId2RequestIds.add("R3P2");
        map.put(personId2, personId2RequestIds);

        return map;
    }

    @Override
    public void iterateAndDeleteOriginalMap(Map<String, List<String>> originalMap) {
        // Not worked -  throwed ConcurrentModificationException
        /*Map<String, List<String>> clonedMap = cloneMap(originalMap);*/

        // Worked
        /*Map<String, List<String>> clonedMap = new HashMap<>();
        originalMap.forEach((personId, requestIdList) -> {
            List<String> requestIds = new ArrayList<>(requestIdList);
            clonedMap.put(personId, requestIds);
        });*/


        // Not worked (No need, originalMap should be ConcurrentHashMap)
        //Map<String, List<String>> clonedMap = new ConcurrentHashMap<>(originalMap);

        System.out.println("===========> Cloned Map");
        System.out.println("===========> Deleting requests");

        // Worked
        for (Map.Entry<String, List<String>> entry : originalMap.entrySet()) {
            for (String requestId : entry.getValue()) {
                List<String> requests = originalMap.get(entry.getKey());
                requests.remove(requestId);
                //originalMap.put(entry.getKey(), requests);
            }
        }

        // Not worked
        /*for (Map.Entry<String, List<String>> entry : originalMap.entrySet()) {
            for (String requestId : entry.getValue()) {
                List<String> requests = originalMap.get(entry.getKey());
                requests.remove(requestId);
                //originalMap.put(entry.getKey(), requests);
            }
        }*/

        // Not worked
        /*Iterator<Map.Entry<String, List<String>>> mapIterator = originalMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, List<String>> entry = mapIterator.next();
            List<String> requestIdList = originalMap.get(entry.getKey());
            for (String requestId : entry.getValue()) {
                requestIdList.remove(requestId);
                originalMap.put(entry.getKey(), requestIdList);
            }

        }*/

        // Not worked
        /*Iterator<Map.Entry<String, List<String>>> mapIterator = originalMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, List<String>> entry = mapIterator.next();
            List<String> requestIdList = originalMap.get(entry.getKey());
            for (String requestId : entry.getValue()) {
                requestIdList.remove(requestId);
            }
        }*/


        System.out.println("===========> Deleted requests");
    }

    // Not worked -  throwed ConcurrentModificationException
    /*private <K, V> Map<K, V> cloneMap(Map<K, V> originalMap) {
        return originalMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                                          Map.Entry::getValue));
    }*/

    @Override
    public void printEntries(Map<String, List<String>> originalMap) {
        for (Map.Entry<String, List<String>> entry : originalMap.entrySet()) {
            System.out.println("Person : " + entry.getKey() + " has requests : " + entry.getValue());
        }
    }
}
