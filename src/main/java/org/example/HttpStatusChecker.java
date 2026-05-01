package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.Util.client;

public class HttpStatusChecker {

    public static String getStatusImage(int code) throws StatusImageNotFoudError, IOException, InterruptedException {
        try {
            String Url = "https://http.cat/" + code + ".jpg";
            HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI(Url))
                        .GET()
                        .headers("Accept", "application/json")
                        .timeout(java.time.Duration.ofSeconds(5))
                        .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404) throw new StatusImageNotFoudError(code);
            return Url;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
