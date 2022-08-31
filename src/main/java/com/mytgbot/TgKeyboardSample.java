package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TgKeyboardSample extends TelegramLongPollingBot {

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

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

                List<KeyboardRow> keyboard = new ArrayList<>();

                KeyboardRow row = new KeyboardRow();
                row.add("111");
                row.add("1111111");
                keyboard.add(row);

                row = new KeyboardRow();
                row.add("222");
                keyboard.add(row);

                row = new KeyboardRow();
                row.add("/hide");
                keyboard.add(row);

                replyKeyboardMarkup.setKeyboard(keyboard);

                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("keyboard");
                message.setReplyMarkup(replyKeyboardMarkup);

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else if(messageFromBot.equals("/hide_keyboard")){
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText(".");
                message.setReplyMarkup(new ReplyKeyboardRemove(true));

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
