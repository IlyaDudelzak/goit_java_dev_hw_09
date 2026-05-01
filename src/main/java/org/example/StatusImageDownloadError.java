package org.example;

public class StatusImageDownloadError extends Exception {
    int statusCode;
    public StatusImageDownloadError(String s, int code) {
        super(s);
        statusCode = code;
    }
}
