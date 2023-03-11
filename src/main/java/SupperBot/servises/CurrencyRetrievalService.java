package SupperBot.servises;

import SupperBot.dto.CurrencyRateDto2;
import java.util.List;


public interface CurrencyRetrievalService {

        List<CurrencyRateDto2> getCurrencyRates();
}
