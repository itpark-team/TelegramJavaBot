package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TgInlineKeyboardSample extends TelegramLongPollingBot {
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
            long chat_id = update.getMessage().getChatId();

            if (messageFromBot.equals("/start")) {

                InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();

                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

                List<InlineKeyboardButton> row = new ArrayList<>();
                InlineKeyboardButton button = new InlineKeyboardButton();
                button.setText("Update message text");
                button.setCallbackData("update_msg_text");
                row.add(button);

                button = new InlineKeyboardButton();
                button.setText("Update message text2");
                button.setCallbackData("update_msg_text2");
                row.add(button);

                keyboard.add(row);

                replyKeyboardMarkup.setKeyboard(keyboard);

                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("Inline keyboard");
                message.setReplyMarkup(replyKeyboardMarkup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.hasCallbackQuery()) {
            String callbackDataFromBot = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            String responseText = "";

            switch (callbackDataFromBot) {
                case "update_msg_text":
                    responseText = "button left";
                    break;

                case "update_msg_text2":
                    responseText = "button right";
                    break;
            }

//            SendMessage message = new SendMessage();
//            message.setChatId(chat_id);
//            message.setText(responseText);

            EditMessageText message = new EditMessageText();
            message.setChatId(chat_id);
            message.setMessageId(messageId);
            message.setText(responseText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }
}
