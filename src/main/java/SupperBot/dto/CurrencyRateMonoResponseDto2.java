package SupperBot.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CurrencyRateMonoResponseDto2 {

    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;
}


