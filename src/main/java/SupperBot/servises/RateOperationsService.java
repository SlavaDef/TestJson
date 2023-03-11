package SupperBot.servises;

import SupperBot.Enums.Currency;
import SupperBot.dto.CurrencyRateDto;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RateOperationsService {

    // список всіх сервісів які вміють діставати курси.
    private List<CurrencyRetrievalService> retrievalServices = List.of(
            new CurrencyRetrievalMonoService(),
            new CurrencyRetrievalPrivatService()
    );

    // дістати інфо по всім відомим валютам з усіх банків
    public List<CurrencyRateDto> getActualRates(){
        return retrievalServices.stream()
                .map(CurrencyRetrievalService::getCurrencyRates)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // отримати найвигідніші курси заданої валюти
    public Map<String, CurrencyRateDto> getBestRates(Currency currency) {
        List<CurrencyRateDto> rates = getActualRates();
        rates = rates.stream()
                // залишити тільки потрібну валюту
                .filter(item -> currency.equals(item.getCurrency()))
                .collect(Collectors.toList());

        // отримання курсу купівлі: (найбільший = найкращій)
        CurrencyRateDto buyRate = rates.stream()
                .max(Comparator.comparing(CurrencyRateDto::getBuyRate))
                .get();

        // отримання курсу продажу: (найменший = найкращій)
        CurrencyRateDto sellRate = rates.stream()
                .min(Comparator.comparing(CurrencyRateDto::getBuyRate))
                .get();

        // збираю мапу відповідей
        return Map.of(
                "buy", buyRate,
                "sell", sellRate
        );
    }
}
