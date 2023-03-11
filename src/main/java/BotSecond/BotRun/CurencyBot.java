package BotSecond.BotRun;

import BotSecond.servise.CurrencyRetvievalPrivatService;
import BotSecond.servise.CurrencyRetvievalervice;
import BotSecond.servise.PrettyRateResponceServise;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class CurencyBot extends TelegramLongPollingBot {

    private CurrencyRetvievalervice currencyRetvievalervice = new CurrencyRetvievalPrivatService();

    // в данному класі, від якого наслідуємося буде достатньо перевизначити три метода
    // LongPolling означае що сервер буде відповідати якщо від клієнта є запит


    //getBotUsername() та getBotToken()  це унікальні сторонні індефікатори для створення боту
        @Override
        public String getBotUsername() {
            return "GoItTenBot";
        }

        @Override
        public String getBotToken() {
            return "6115863445:AAFHuVnAqyX7wb3PkemaJ07g_iz6wjCVS4g";
        }

    @Override
    public void onUpdateReceived(Update update) {
        // логіка цього метода в тому що треба виконати якщо приходить повідомлення від користувача

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) { // якщо є повідомлення і вньому є текст
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString()); // в який чат писати повідомлення
          //  message.setText(update.getMessage().getText());// в той з якого прийшло
            // тепер замість тексту ехо будемо отримувати наші курси валют поки з привату
            message.setText(PrettyRateResponceServise.formResponce(
                    update.getMessage().getText(),
                    currencyRetvievalervice.getCurencyRates()));
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
    }


