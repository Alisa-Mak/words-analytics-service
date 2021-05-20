package com.adaptavist.fileanalytics.service.utils;

import java.util.Comparator;
import java.util.Map;

/**
 * Comparator to sort the collection by words frequency descendent and alphabetically
 */
public class EntityComparator implements Comparator<Map.Entry<String,Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        int result = entry2.getValue().compareTo(entry1.getValue());
        if(result == 0){
            return entry1.getKey().compareTo(entry2.getKey());
        }
        return result;
    }
}
