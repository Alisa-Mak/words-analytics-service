package com.adaptavist.fileanalytics.service.utils;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CalcUtils {

    final static String REGEX = "\\W+";
    final static int initFrequency = 0;

    public Map<String, Integer> getWordsFrequency(Stream<String> lines) {
        Map<String, Integer> wordsToFrequency = new HashMap<>();
        lines.forEach(line -> {
            Stream<String> words = Arrays.stream(line.split(REGEX)).map(String::toLowerCase);
            words.filter(word -> !word.isEmpty()).forEach(word ->
                    wordsToFrequency.put(word, wordsToFrequency.getOrDefault(word, initFrequency) + 1)
            );
        });
        return wordsToFrequency;
    }

    public List<Map.Entry<String, Integer>> sortWordsFrequency(Map<String, Integer> wordsToFrequency) {
        return wordsToFrequency
                .entrySet()
                .stream()
                .sorted(new EntityComparator())
                .collect(
                        Collectors.toList());
    }
}
