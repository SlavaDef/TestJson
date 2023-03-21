package NetBot;

import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

public class SimpleEchoBot extends TelegramLongPollingBot {

    static final Logger LOG2 = (Logger) LoggerFactory.getLogger(Application.class);

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String textFromUser = update.getMessage().getText();

            Long userId = update.getMessage().getChatId();
            String userFirstName = update.getMessage().getFrom().getFirstName();

     //       LoggerFactory.getLogger(Application.class).info("[{}, {}] : {}", userId, userFirstName, textFromUser);

            SendMessage sendMessage = SendMessage.builder()
                    .chatId(userId.toString())
                    .text("Hello, I've received your text: " + textFromUser)
                    .build();
            try {
                this.sendApiMethod(sendMessage);
            } catch (TelegramApiException e) {
                 LoggerFactory.getLogger(Application.class).error("Exception when sending message: ", e);
            }
        } else {
            LoggerFactory.getLogger(Application.class).warn("Unexpected update from user");
        }
    }

    @Override
    public String getBotUsername() {
        return "your_bot_username ";
    }

    @Override
    public String getBotToken() {
        return "bot_token";
    }
}
