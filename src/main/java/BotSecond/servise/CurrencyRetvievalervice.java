package BotSecond.servise;

import BotSecond.Dto.CurrencyRateDto;

import java.util.Set;

public interface CurrencyRetvievalervice {
    Set<CurrencyRateDto> getCurencyRates();
}
