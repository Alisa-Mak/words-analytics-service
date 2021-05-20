package com.adaptavist.fileanalytics.service;

import com.adaptavist.fileanalytics.exception.OpenFileException;
import org.springframework.stereotype.Service;

import java.io.File;

/***
 * This service is for retrieving the file
 */
@Service
public class FileReaderService {

    /**
     *
     * @param path - absolute path to file
     * @return file at the specified location
     */
    File getFileForPath(String path) {
        try {
            File file = new File(path);
            if(file.exists() && !file.isDirectory()) {
                return file;
            }
            throw new OpenFileException(path);
        } catch (Exception e) {
            throw new OpenFileException(path);
        }
    }
}
