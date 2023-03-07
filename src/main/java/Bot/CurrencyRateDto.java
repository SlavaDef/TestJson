package Bot;

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
}
