package com.adaptavist.fileanalytics.service;

import com.adaptavist.fileanalytics.exception.ReadFileException;
import com.adaptavist.fileanalytics.service.utils.CalcUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.net.URL;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WordsCounterServiceTest {

    @Mock
    FileReaderService fileServiceMock;
    @Mock
    CalcUtils calcUtilsMock;

    WordsCounterService service;
    String filePath = "test_files/sample_file.txt";

    @BeforeEach
    public void initTests() {
        service = new WordsCounterService(fileServiceMock, calcUtilsMock);
    }

    @Test
    public void calcWordsForFileHappyPath() {
        Map<String, Integer> unsortedResult = new HashMap<>();
        List<Map.Entry<String, Integer>> expectedSortedResult = new ArrayList<>();

        URL resource = Thread.currentThread().getContextClassLoader().getResource(filePath);
        File file = new File(Objects.requireNonNull(resource).getFile());

        when(fileServiceMock.getFileForPath(filePath)).thenReturn(file);
        when(calcUtilsMock.getWordsFrequency(any())).thenReturn(unsortedResult);
        when(calcUtilsMock.sortWordsFrequency(any())).thenReturn(expectedSortedResult);

        List<Map.Entry<String, Integer>> actualSortedResult = service.calcWordsForFile(filePath);

        assertEquals(expectedSortedResult, actualSortedResult);
    }

    @Test
    public void calcWordsForFileThrowsException() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(filePath);
        File file = new File(Objects.requireNonNull(resource).getFile());

        when(fileServiceMock.getFileForPath(filePath)).thenReturn(file);
        when(calcUtilsMock.getWordsFrequency(any())).thenThrow(new RuntimeException());

        Assertions.assertThrows(ReadFileException.class, () -> service.calcWordsForFile(filePath));
    }
}
