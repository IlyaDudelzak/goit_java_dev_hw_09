package org.example;

public class StatusImageNotFoudError extends Exception {
    int statusCode;
    public StatusImageNotFoudError(int code) {
        super("No status image found for status code " + code);
        statusCode = code;
    }
}
