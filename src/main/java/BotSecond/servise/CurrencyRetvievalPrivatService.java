package BotSecond.servise;

import BotSecond.Dto.CurrencyRateDto;
import BotSecond.Dto.CurrencyRatePrivatResponceDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CurrencyRetvievalPrivatService implements CurrencyRetvievalervice {
    // силка на курси в ip Privat
    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";
    @Override
    public List<CurrencyRateDto> getCurencyRates()  {

     try {
         String responce = Jsoup.connect(URL)
                 .ignoreContentType(true) // якщо хо отрімувати відповідь у вигляді Json
                 .get()
                 .body()
                 .text();
         List<CurrencyRatePrivatResponceDto> responceDto = convertResponceToSet(responce);

         // new CurrencyRateDto(dto.getCcy(), dto.getBuy(), dto.getSale()))
       return  responceDto.stream()
                 .map(dto -> new CurrencyRateDto(dto.getCcy(),dto.getBuy(), dto.getSale()))
                 .collect(Collectors.toList());
     }
     catch (IOException e){
        throw  new RuntimeException(e);
     }

    }

    private List<CurrencyRatePrivatResponceDto> convertResponceToSet(String responce){
        // робимо тайп токен для того щоб витягнути список обьектів
        Type type = TypeToken.getParameterized(Set.class, CurrencyRatePrivatResponceDto.class).getType();
        Gson gson = new Gson();
        // в лист засовуємо все що витягнули з класу


        // resalt - responceDto = [CurrencyRatePrivatResponceDto{ccy=EUR, base_ccy=UAH, buy=38.54000, sale=40.16064},
        // CurrencyRatePrivatResponceDto{ccy=USD, base_ccy=UAH, buy=36.56860, sale=37.45318}]
        //тепер можна доставати окремий елемент з обьекту

            return gson.fromJson(responce,type);
    }

}
