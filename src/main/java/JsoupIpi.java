import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsoupIpi {

   private static String objectLink = "https://jsonplaceholder.typicode.com/users";

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {



System.out.println(createObject2().headers());

    }


    public void createObject(String link) throws IOException {

        link = "https://jsonplaceholder.typicode.com/";

        Document document = Jsoup.connect(link)
                .get();

        System.out.println("---?" + document.body().text());



    }

    public static HttpResponse createObject2() throws IOException, URISyntaxException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(objectLink))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Leanne Graham\",\n" +
                        "    \"username\": \"Bret\",\n" +
                        "    \"email\": \"Sincere@april.biz\",\n" +
                        "    \"address\": {\n" +
                        "      \"street\": \"Kulas Light\",\n" +
                        "      \"suite\": \"Apt. 556\",\n" +
                        "      \"city\": \"Gwenborough\",\n" +
                        "      \"zipcode\": \"92998-3874\",\n" +
                        "      \"geo\": {\n" +
                        "        \"lat\": \"-37.3159\",\n" +
                        "        \"lng\": \"81.1496\"\n" +
                        "      }\n" +
                        "    }"))
                        .GET()
                        .build();

     return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());


    }

}
