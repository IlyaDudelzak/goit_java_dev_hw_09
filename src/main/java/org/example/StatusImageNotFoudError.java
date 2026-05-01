package org.example;

public class StatusImageNotFoudError extends Exception {
    int statusCode;
    public StatusImageNotFoudError(int code) {
        super("No status code image found for status code " + code);
        statusCode = code;
    }
}
