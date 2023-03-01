package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HtttpConspekt {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient(); // кліент

        HttpRequest request = HttpRequest.newBuilder() // запрос
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .GET()
               // .POST()
                .timeout(Duration.of(10, ChronoUnit.SECONDS)) // час очікування якщо немає відповіді буде помилка
                .build();
        // ofString() конвертуємо в String
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString()); // відповідь

        System.out.println("headers = " + response.headers()); // поверне заголовки
        System.out.println("body = " + response.body()); // поверне тіло файлу
        System.out.println("status = " + response.statusCode()); // поверне статус
        System.out.println("status = " + response);
    }
}
