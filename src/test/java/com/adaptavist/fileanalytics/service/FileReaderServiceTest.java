package com.adaptavist.fileanalytics.service;

import com.adaptavist.fileanalytics.exception.OpenFileException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReaderServiceTest {

    final String filePath = "test_files/sample_file.txt";
    final String nonExistingPath = "test_files/sample_file_non_existing.txt";
    final FileReaderService service = new FileReaderService();

    @Test
    public void getFileHappyPath() throws IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(filePath);
        File expectedFile = new File(Objects.requireNonNull(resource).getFile());
        File actualFile = service.getFileForPath(expectedFile.getAbsolutePath());

        assertTrue(FileUtils.contentEquals(expectedFile, actualFile));
    }

    @Test
    public void nonExistingFileThrowsException() {
        Assertions.assertThrows(OpenFileException.class, () -> {
            service.getFileForPath(nonExistingPath);
        });
    }
}
