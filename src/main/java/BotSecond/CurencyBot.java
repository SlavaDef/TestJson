package BotSecond;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CurencyBot extends TelegramLongPollingBot {

    // в данному класі, від якого наслідуємося буде достатньо перевизначити три метода
    // LongPolling означае що сервер буде відповідати якщо від клієнта є запит


    //getBotUsername() та getBotToken()  це унікальні сторонні індефікатори для створення боту
        @Override
        public String getBotUsername() {
            // TODO
            return null;
        }

        @Override
        public String getBotToken() {
            // TODO
            return null;
        }

    @Override
    public void onUpdateReceived(Update update) {
        // логіка цього метода в тому що треба виконати якщо приходить повідомлення від користувача

    }
    }


