package com.adaptavist.fileanalytics.service;

import com.adaptavist.fileanalytics.exception.ReadFileException;
import com.adaptavist.fileanalytics.service.utils.CalcUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

/***
 * This service is for file words calculation and analysis
 */
@Service
@AllArgsConstructor
public class WordsCounterService {

    final FileReaderService fileService;
    final CalcUtils utils;

    /**
     * @param filePath - path to the file
     * @return - map of words to number of occurrences descending order
     */
    public List<Map.Entry<String, Integer>> calcWordsForFile(String filePath) {
        File file = fileService.getFileForPath(filePath);

        try (Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
            Map<String, Integer> wordsToFrequency = utils.getWordsFrequency(lines);
            return utils.sortWordsFrequency(wordsToFrequency);

        } catch (Exception e) {
            throw new ReadFileException(file.getName());
        }
    }
}
