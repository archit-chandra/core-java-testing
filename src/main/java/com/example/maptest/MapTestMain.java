package com.example.maptest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import com.example.maptest.service.MapService;
import com.example.maptest.service.MapServiceImpl;

public class MapTestMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(MapTestMain.class.getName());

        MapService mapService = new MapServiceImpl();

        Map<String, List<String>> originalMap = mapService.getOriginalMap();
        mapService.printEntries(originalMap);

        mapService.iterateAndDeleteOriginalMap(originalMap);
        System.out.println("originalMap is empty : " + originalMap.isEmpty());

        if (!originalMap.isEmpty()) {
            mapService.printEntries(originalMap);
        }
    }
}
