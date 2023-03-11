package SupperBot.dto;

import SupperBot.Enums.BankName;
import SupperBot.Enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CurrencyRateDto {
    private Currency currency;
    private BigDecimal buyRate;
    private BigDecimal sellRate;
    private BankName bankName;
}
