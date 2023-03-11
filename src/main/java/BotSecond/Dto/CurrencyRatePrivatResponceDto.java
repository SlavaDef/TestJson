package BotSecond.Dto;

import BotSecond.Dto.Currency;

import java.math.BigDecimal;

public class CurrencyRatePrivatResponceDto {

// в цьому класі прописуємо всі змінні отриманної відповіді
// відповідь {"ccy":"EUR","base_ccy":"UAH","buy":"38.54000","sale":"40.16064"},{"ccy":"USD","base_ccy":"UAH","buy":"36.56860","sale":"37.45318"}

//@Getter // завдяки бібліотеці lombok всі гетери і сетери будуть згенеровані автоматично
//@Setter
private Currency ccy; // Currency це ссилка на єнам
  private  Currency base_ccy;
  private BigDecimal buy; // BigDecimal  клас для работи з великими числами якi можуть бути быльшы за long
  private BigDecimal sale;

  public Currency getCcy() {
    return ccy;
  }

  public void setCcy(Currency ccy) {
    this.ccy = ccy;
  }

  public Currency getBase_ccy() {
    return base_ccy;
  }

  public void setBase_ccy(Currency base_ccy) {
    this.base_ccy = base_ccy;
  }

  public BigDecimal getBuy() {
    return buy;
  }

  public void setBuy(BigDecimal buy) {
    this.buy = buy;
  }

  public BigDecimal getSale() {
    return sale;
  }

  public void setSale(BigDecimal sale) {
    this.sale = sale;
  }

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
