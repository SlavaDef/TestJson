import com.google.gson.Gson;
import com.tunyk.currencyconverter.BankUaCom;
import com.tunyk.currencyconverter.api.Currency;
import com.tunyk.currencyconverter.api.CurrencyConverterException;

import java.util.Collections;
import java.util.Map;

public class Convector {

    public static void main(String[] args) throws CurrencyConverterException {

// в пром загрузили стороннюю библиотеку конвектор, создаем обьект и конвертируем
     /*   com.tunyk.currencyconverter.AbstractCurrencyConverter currencyConverter =
                new BankUaCom(Currency.USD,Currency.UAH);
        float answer = currencyConverter.convertCurrency(1000f);
        System.out.println(answer);  */

        Map<String,String> human = Collections.singletonMap("name", "Bob G");

        System.out.println("resalt = " + new Gson().toJson(human));

    }
}
