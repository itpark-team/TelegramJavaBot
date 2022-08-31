package com.mytgbot.statemachine;


import com.mytgbot.statemachine.controller.BotLogic;
import com.mytgbot.statemachine.model.DataStorage;
import com.mytgbot.statemachine.model.DataStorageKeys;
import com.mytgbot.statemachine.model.TransmittedData;
import com.mytgbot.statemachine.model.User;
import com.mytgbot.statemachine.util.SystemState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

public class ChatsRouter {
    private Map<Long, TransmittedData> chats;
    private BotLogic botLogic;

    public ChatsRouter() {
        chats = new HashMap<>();
        botLogic = new BotLogic();
    }


    public void processMessage(TelegramLongPollingBot bot, Update update) {
        long chatId = -1;

        if (update.hasMessage()) {
            chatId = update.getMessage().getChatId();
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
        }

        if (chats.get(chatId) == null) {
            DataStorage dataStorage = new DataStorage();
            dataStorage.add(DataStorageKeys.USER, new User());

            TransmittedData transmittedData = new TransmittedData(dataStorage, SystemState.PROCESS_START);

            chats.put(chatId, transmittedData);
        }

        TransmittedData transmittedData = chats.get(chatId);

        botLogic.processMessage(transmittedData, bot, chatId, update);
    }
}
