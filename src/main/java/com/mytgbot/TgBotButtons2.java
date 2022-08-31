package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TgBotButtons2 extends TelegramLongPollingBot {
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
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (update.getMessage().getText().equals("/start")) {

                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

                List<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                row.add("111");
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
                message.setText("sdfsdf");
                message.setReplyMarkup(replyKeyboardMarkup);

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if (update.getMessage().getText().equals("/hide")) {
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("Removing keyboard");
                message.setReplyMarkup(new ReplyKeyboardRemove(true, null));

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void sendFirstMessage(){
        SendMessage message = new SendMessage();
        message.setChatId(247021014l);
        message.setText("AAAAAAA");
        try {
            execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
