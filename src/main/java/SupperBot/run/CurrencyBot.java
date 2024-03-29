package SupperBot.run;

import SupperBot.Enums.Currency;
import SupperBot.servises.PrettyRateResponseService;
import SupperBot.servises.RateOperationsService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;

public class CurrencyBot extends TelegramLongPollingBot {

    private RateOperationsService rateOperationsService = new RateOperationsService();

    @Override
    public String getBotUsername() {
        return "NewExange66Bot";
    }

    @Override
    public String getBotToken() {
        return "6231081451:AAF-ZNYrCqNtKkNbLo-cBFS0bnauL6OrYaE";
    }

    // accepted commands: buy, sell, usd, eur
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("here");
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(resolveCommand(update.getMessage().getText()));
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String resolveCommand(String command) {
        command = command.toUpperCase();
        Currency currency = null;
        try {
            currency = Currency.valueOf(command);
        } catch (IllegalArgumentException e) {
        }
        if (currency != null) {
            return PrettyRateResponseService.formBestRateResponse(rateOperationsService.getBestRates(currency));
        } else {
            return PrettyRateResponseService.formAllRateResponse(command,  rateOperationsService.getActualRates());
        }
    }
}
