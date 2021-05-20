package com.adaptavist.fileanalytics.exception;

/**
 * Exception is thrown when the file rows can not be processed
 */
public class OpenFileException extends RuntimeException {

    final static String ERR_MESSAGE = "Unable to open file in path : {0}";

    public OpenFileException(String filePath) {
        super(java.text.MessageFormat.format(ERR_MESSAGE, filePath));
    }
}
