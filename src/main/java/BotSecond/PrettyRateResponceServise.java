package BotSecond;

import java.util.Set;
import java.util.stream.Collectors;

public class PrettyRateResponceServise {

    private static String RESPONSE_TEMPLATE = "Для валюты cur курс rate.\n";

    // клас буде відповідати за гарне виведення валюти приймає команду Buy чи Sell і сет відповіді

    public static String formResponce(String comand, Set<CurrencyRateDto> rates){
        comand = comand.toUpperCase();
        String res;
switch (comand){

    case "BUY": {
       res = rates.stream()
                .map(item -> RESPONSE_TEMPLATE.replace("cur", item.getCurrency().toString())
                            .replace("rate", item.getBuyRate().toString())
                )
                .collect(Collectors.joining());
// проходимся по колекції і міняємо назву валюти на потрібну і курс

    }
    break;

    case "SELL": {
        res =  rates.stream()
                .map(item -> RESPONSE_TEMPLATE.replace("cur", item.getCurrency().toString())
                        .replace("rate", item.getSellRate().toString())
                )
                .collect(Collectors.joining());
    }
    break;

    default: {
        res = "Доступны команди BUY та SELL";
    }
}
return res;
    }
}
