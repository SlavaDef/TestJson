package SupperBot.servises;



import BotSecond.Dto.CurrencyRateDto;

import java.util.List;

public interface CurrencyRetrievalService {

        List<CurrencyRateDto> getCurrencyRates();
}
