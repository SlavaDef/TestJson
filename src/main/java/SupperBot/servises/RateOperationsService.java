package SupperBot.servises;


import SupperBot.Enums.Currency;
import SupperBot.dto.CurrencyRateDto2;
import java.util.*;
import java.util.stream.Collectors;

public class RateOperationsService {

    // список всіх сервісів які вміють діставати курси.
    private List<CurrencyRetrievalService> retrievalServices = List.of(
            new CurrencyRetrievalMonoService(),
            new CurrencyRetrievalPrivatService()
    );

    // дістати інфо по всім відомим валютам з усіх банків
    public List<CurrencyRateDto2> getActualRates(){
        return retrievalServices.stream()
                .map(CurrencyRetrievalService::getCurrencyRates)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // отримати найвигідніші курси заданої валюти
    public Map<String, CurrencyRateDto2> getBestRates(Currency currency) {
        List<CurrencyRateDto2> rates = getActualRates();
        rates = rates.stream()
                // залишити тільки потрібну валюту
                .filter(item -> currency.equals(item.getCurrency()))
                .collect(Collectors.toList());

        // отримання курсу купівлі: (найбільший = найкращій)
        CurrencyRateDto2 buyRate = rates.stream()
                .max(Comparator.comparing(CurrencyRateDto2::getBuyRate))
                .get();

        // отримання курсу продажу: (найменший = найкращій)
        CurrencyRateDto2 sellRate = rates.stream()
                .min(Comparator.comparing(CurrencyRateDto2::getBuyRate))
                .get();

        // збираю мапу відповідей
        return Map.of(
                "buy", buyRate,
                "sell", sellRate
        );
    }
}
