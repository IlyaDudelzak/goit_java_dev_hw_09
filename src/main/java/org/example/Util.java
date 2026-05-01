package org.example;

import java.net.http.HttpClient;

public class Util {
    static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
}
