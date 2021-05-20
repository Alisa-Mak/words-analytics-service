package com.adaptavist.fileanalytics.service.utils;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalcUtilsTest {

    CalcUtils utils = new CalcUtils();

    @Test
    public void getWordsFrequency() {
        String[] testText = {"java", "python", "Nodejs", "ruby", "java", "nodejs", "C", "Java"};

        Stream<String> lines = Arrays.stream(testText);
        Map<String, Integer> actualResult = utils.getWordsFrequency(lines);
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("java", 3);
        expectedResult.put("python", 1);
        expectedResult.put("nodejs", 2);
        expectedResult.put("c", 1);
        expectedResult.put("ruby", 1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sortWordsFrequency() {
        Map<String, Integer> inputData = new HashMap<>();
        inputData.put("python", 1);
        inputData.put("c", 1);
        inputData.put("java", 3);
        inputData.put("ruby", 1);
        inputData.put("nodejs", 2);
        inputData.put("12", 1);

        List<Map.Entry<String, Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(new AbstractMap.SimpleEntry<>("java", 3));
        expectedResult.add(new AbstractMap.SimpleEntry<>("nodejs", 2));
        expectedResult.add(new AbstractMap.SimpleEntry<>("12", 1));
        expectedResult.add(new AbstractMap.SimpleEntry<>("c", 1));
        expectedResult.add(new AbstractMap.SimpleEntry<>("python", 1));
        expectedResult.add(new AbstractMap.SimpleEntry<>("ruby", 1));

        List<Map.Entry<String, Integer>> actualResult = utils.sortWordsFrequency(inputData);

        assertTrue(linkedMapsEqual(expectedResult, actualResult));
    }

    private <K, V> boolean linkedMapsEqual(List<Map.Entry<K, V>> left, List<Map.Entry<K, V>> right) {
        Iterator<Map.Entry<K, V>> leftItr = left.iterator();
        Iterator<Map.Entry<K, V>> rightItr = right.iterator();

        while (leftItr.hasNext() && rightItr.hasNext()) {
            Map.Entry<K, V> leftEntry = leftItr.next();
            Map.Entry<K, V> rightEntry = rightItr.next();

            if (!leftEntry.equals(rightEntry))
                return false;
        }
        return !(leftItr.hasNext() || rightItr.hasNext());
    }
}
