package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {
    @Test
    void getStatusImageTest() {
        assertDoesNotThrow(() -> {
            assertEquals("https://http.cat/200.jpg", HttpStatusChecker.getStatusImage(200));
            assertEquals("https://http.cat/404.jpg", HttpStatusChecker.getStatusImage(404));
        });
        assertThrows(StatusImageNotFoudError.class, () -> HttpStatusChecker.getStatusImage(10000));
    }
}