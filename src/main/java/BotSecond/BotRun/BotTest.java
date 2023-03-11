package BotSecond.BotRun;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class BotTest {

    public static void main(String[] args) throws IOException {


        // System.out.println( " Ansver is " + new CurrencyRetvievalPrivatService().getCurencyRates());

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CurencyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
