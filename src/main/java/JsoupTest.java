import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupTest {

    public static void main(String[] args) throws IOException {


      Document doc =   Jsoup.
                connect("https://bt.rozetka.com.ua/ua/philips-hu2510-10/p354228279/")
                .get();

      //doc
              //body() // можна подивитися тіло
              // .head()  чи заголовок
              // .html() чи перевезти до html

        System.out.println("Doc body = " + doc.body().text());
// selectFirst() -> метод який знаходить перше співпадіння по тегу який ми передамо
       Element element =  doc.selectFirst("p.product-price");
        System.out.println("element = "+ element.text());
    }
}
