package NetBot;

import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.logging.Logger;

public class Application {

     static final Logger LOG = (Logger) LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            LOG.info("Registering bot...");
            telegramBotsApi.registerBot(new SimpleEchoBot());
        } catch (TelegramApiRequestException e) {
            //e.printStackTrace();
            LoggerFactory.getLogger(Application.class).error("Failed to register bot(check internet connection / bot token or make sure only one instance of bot is running).", e);
        }
        LOG.info("Telegram bot is ready to accept updates from user......");
    }
}
