package SupperBot.servises;

import SupperBot.Enums.BankName;
import SupperBot.dto.CurrencyRateDto2;
import SupperBot.dto.CurrencyRatePrivatResponseDto2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyRetrievalPrivatService implements CurrencyRetrievalService{

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";
    @Override
    public List<CurrencyRateDto2> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyRatePrivatResponseDto2> responseDtos = convertResponseToList(response);
            return responseDtos.stream()
                    // тепер додаю назву банку щоб потім зрозуміті курс якого банку був найвигіднішим
                    .map(dto -> new CurrencyRateDto2(dto.getCcy(), dto.getBuy(), dto.getSale(), BankName.PRIVATBANK))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<CurrencyRatePrivatResponseDto2> convertResponseToList(String response) {
        Type type = TypeToken.getParameterized(List.class, CurrencyRatePrivatResponseDto2.class).getType();
        Gson gson = new Gson();
        return gson.fromJson(response, type);
    }


}
