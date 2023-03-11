package SupperBot.servises;


import SupperBot.Enums.BankName;
import SupperBot.Enums.Currency;
import SupperBot.dto.CurrencyRateDto;
import SupperBot.dto.CurrencyRateMonoResponseDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static SupperBot.Enums.Currency.*;


public class CurrencyRetrievalMonoService implements CurrencyRetrievalService {

    private static final String URL = "https://api.monobank.ua/bank/currency";
    // бо волюти приходять кодами
    private static Map<Integer, Currency> codeCurr = Map.of(
            980, UAH,
            840, USD,
            978, EUR
    );

    @Override
    public List<CurrencyRateDto> getCurrencyRates() {
        try {
            String response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyRateMonoResponseDto> currencyRateResponses = convertResponseToList(response);
            return currencyRateResponses.stream()
                    .filter(item -> codeCurr.containsKey(item.getCurrencyCodeA())
                            && codeCurr.containsKey(item.getCurrencyCodeB())
                            && item.getCurrencyCodeB().equals(980)
                    )
                    // тепер додаю назву банку щоб потім зрозуміті курс якого банку був найвигіднішим
                    .map(item -> new CurrencyRateDto(
                            codeCurr.get(item.getCurrencyCodeA()),
                            item.getRateBuy(),
                            item.getRateSell(),
                            BankName.MONOBANK
                    ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<CurrencyRateMonoResponseDto> convertResponseToList(String response) {
        Type type = TypeToken.getParameterized(List.class, CurrencyRateMonoResponseDto.class).getType();
        Gson gson = new Gson();
        return gson.fromJson(response, type);
    }


}
