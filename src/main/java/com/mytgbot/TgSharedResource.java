package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TgSharedResource extends TelegramLongPollingBot {

    private SharedResourceManager sharedResourceManager;

    public TgSharedResource(SharedResourceManager sharedResourceManager) {
        this.sharedResourceManager = sharedResourceManager;
    }

    @Override
    public String getBotUsername() {
        return "javaJokesTest208bot";
    }

    @Override
    public String getBotToken() {
        return "5519053501:AAEfqK5gzZD-X6k-k6lesOFwPpVabmfEKeM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageFromBot = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            if (messageFromBot.startsWith("/rnd")) {

                sharedResourceManager.rndX(chatId);

                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("randomized");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (messageFromBot.startsWith("/get")) {

                int x = sharedResourceManager.getX(chatId);

                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText(Integer.toString(x));

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
