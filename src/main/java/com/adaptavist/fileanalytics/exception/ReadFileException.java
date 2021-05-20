package com.adaptavist.fileanalytics.exception;

/**
 * Exception is thrown when the file can not be open
 */
public class ReadFileException extends RuntimeException{

    final static String ERR_MESSAGE = "Unable for read file : {0}";

    public ReadFileException(String filename) {
        super(java.text.MessageFormat.format(ERR_MESSAGE, filename));
    }
}
