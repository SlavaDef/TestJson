package BotSecond;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyRateDto {


    private Currency currency;
    private BigDecimal buyRate;
    private  BigDecimal sellRate;

    public CurrencyRateDto() {
    }

    public CurrencyRateDto(Currency currency, BigDecimal buyRate, BigDecimal sellRate) {
        this.currency = currency;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }



    @Override
    public String toString() {
        return "CurrencyRateDto{" +
                "currency=" + currency +
                ", buyRate=" + buyRate +
                ", sellRate=" + sellRate +
                '}';
    }
}
