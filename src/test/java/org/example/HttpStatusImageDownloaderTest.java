package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {
    @ParameterizedTest
    @CsvSource({
            "200,31128,0bbf5650ee65c4af48c69283a6e26b5ea134aca6c459bae6db26bed480e612ef"
    })
    void downloadStatusImageTest(int code, int expectedSize, String expectedHash) {
        assertDoesNotThrow(() -> {
            HttpStatusImageDownloader.downloadStatusImage(200);
            byte[] bytes = Files.readAllBytes(Path.of("status_" + code + ".jpg"));
            long size = bytes.length;

            byte[] hashBytes = MessageDigest.getInstance("SHA-256").digest(bytes);
            String hashHex = HexFormat.of().formatHex(hashBytes);

            assertEquals(expectedSize, size);
            assertEquals(expectedHash, hashHex);

        });
    }
}