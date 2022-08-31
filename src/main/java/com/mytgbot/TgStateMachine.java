package com.mytgbot;

import com.mytgbot.statemachine.ChatsRouter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TgStateMachine extends TelegramLongPollingBot {

    private ChatsRouter chatsRouter;

    public TgStateMachine() {
        chatsRouter = new ChatsRouter();
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
        chatsRouter.processMessage(this, update);
    }
}
