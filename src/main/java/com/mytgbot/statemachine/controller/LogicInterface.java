package com.mytgbot.statemachine.controller;

import com.mytgbot.statemachine.model.TransmittedData;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface LogicInterface {
    void processMessage(TransmittedData transmittedData, TelegramLongPollingBot bot, long chatId, Update update);
}
