package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public interface EditingBotMessage {
    void editMessage(TelegramLongPollingBot tgBot, long chatId, int messageId);
}
