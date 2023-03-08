package BotSecond;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

public class CurrencyRetvievalService {

    public void getCurencyRates()  { // силка на курси в ip Privat
     try {
         String responce = Jsoup.connect("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11")
                 .ignoreContentType(true) // якщо хо отрімувати відповідь у вигляді Json
                 .get()
                 .body()
                 .text();

         // робимо тайп токен для того щоб витягнути список обьектів
         Type type = TypeToken.getParameterized(Set.class, CurrencyRatePrivatResponceDto.class).getType();
         Gson gson = new Gson();
         // в лист засовуємо все що витягнули з класу
         Set<CurrencyRatePrivatResponceDto> responceDto = gson.fromJson(responce,type);

         // resalr - responceDto = [CurrencyRatePrivatResponceDto{ccy=EUR, base_ccy=UAH, buy=38.54000, sale=40.16064},
         // CurrencyRatePrivatResponceDto{ccy=USD, base_ccy=UAH, buy=36.56860, sale=37.45318}]
          //тепер можна доставати окремий елемент з обьекту

         System.out.println("responceDto = " + responceDto);

     }
     catch (IOException e){
        throw  new RuntimeException(e);
     }

    }
}
