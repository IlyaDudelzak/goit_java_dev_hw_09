package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.*;
import java.time.Duration;

import static org.example.Util.client;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws StatusImageNotFoudError, StatusImageDownloadError, IOException, InterruptedException, URISyntaxException {
        String url = HttpStatusChecker.getStatusImage(code);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        if (response.statusCode() != 200) {
            throw new StatusImageDownloadError("Failed to download image for code " + code, code);
        }

        Path path = Paths.get("status_" + code + ".jpg");
        Files.write(path, response.body());
    }
}