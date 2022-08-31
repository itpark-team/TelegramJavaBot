package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.HashMap;
import java.util.Map;

public class BotMultiLevelMenuLogic {
    private Map<String, EditingBotMessage> messagesMap;

    public BotMultiLevelMenuLogic() {
        messagesMap = new HashMap<>();

        messagesMap.put("main_menu", this::sendMainMenu);
        messagesMap.put("goto_a", this::sendMenuA);
        messagesMap.put("goto_b", this::sendMenuB);
    }

    public void callMethodByName(String key, TelegramLongPollingBot tgBot, long chatId, int messageId) {
        messagesMap.get(key).editMessage(tgBot, chatId, messageId);
    }


    private void sendMainMenu(TelegramLongPollingBot tgBot, long chatId, int messageId) {

    }

    private void sendMenuA(TelegramLongPollingBot tgBot, long chatId, int messageId) {
        int a = 5;
    }

    private void sendMenuB(TelegramLongPollingBot tgBot, long chatId, int messageId) {
        int b = 5;
    }
}
