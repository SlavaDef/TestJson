package BotSecond;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

public class CurrencyRatePrivatResponceDto {

// в цьому класі прописуємо всі змінні отриманної відповіді
// відповідь {"ccy":"EUR","base_ccy":"UAH","buy":"38.54000","sale":"40.16064"},{"ccy":"USD","base_ccy":"UAH","buy":"36.56860","sale":"37.45318"}

@Getter // завдяки бібліотеці lombok всі гетери і сетери будуть згенеровані автоматично
@Setter
private Currency ccy; // Currency це ссилка на єнам
  private  Currency base_ccy;
  private BigDecimal buy; // BigDecimal  клас для работи з великими числами якi можуть бути быльшы за long
  private BigDecimal sale;



  @Override
  public String toString() {
    return "CurrencyRatePrivatResponceDto{" +
            "ccy=" + ccy +
            ", base_ccy=" + base_ccy +
            ", buy=" + buy +
            ", sale=" + sale +
            '}';
  }
}
