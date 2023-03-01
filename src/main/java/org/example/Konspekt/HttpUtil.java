package org.example.Konspekt;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {

private static final HttpClient CLIENT = HttpClient.newHttpClient(); // зробили Http кліента
    private static final Gson GSON = new Gson();

    public static  User sendGet(URI uri) throws IOException, InterruptedException {
        // робимо отправку запроса

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        // далі визиваємо кліента і передаємо туди запит (request) і що ми хочемо отримати строковий результат

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        response.body(); // отримали відповідь можемо отримати баді чи...

        // тепер тіло требе перевезти в юзера використовуємо сторонню бібліотеку
        // передаємо цю строку і те що ми хочемо привести до класу юзер

        final User abUser = GSON.fromJson(response.body(), User.class);
        return abUser;

    }

    public static  User sendPost(URI uri, User abUser) throws IOException, InterruptedException { // юзер как тело запроса\
        final String requestBody = GSON.toJson(abUser);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);

    }

    public static void createUser(User user) throws IOException, InterruptedException {
        String userJson = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .POST(HttpRequest.BodyPublishers.ofString(userJson))
                .build();
        HttpResponse response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.statusCode() = " + response.body());

    }
}
