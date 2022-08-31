package com.mytgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TgMultiLevelMenu extends TelegramLongPollingBot {

    private BotMultiLevelMenuLogic botMultiLevelMenuLogic = new BotMultiLevelMenuLogic();

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
                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("com.mytgbot.Main menu");
                message.setReplyMarkup(getMainMenuInlineKeyboard());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } else if (update.hasCallbackQuery()) {
            String callbackDataFromBot = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            botMultiLevelMenuLogic.callMethodByName(callbackDataFromBot, this, chatId, messageId);

//            InlineKeyboardMarkup inlineKeyboardMarkup = null;
//            String text = "";
//
//            switch (callbackDataFromBot) {
//                case "goto_a":
//                    text = "вы перешли в подменю А";
//                    inlineKeyboardMarkup = getMenuAInlineKeyboard();
//                    break;
//
//                case "goto_b":
//                    text = "вы перешли в подменю B";
//                    inlineKeyboardMarkup = getMenuBInlineKeyboard();
//                    break;
//
//                case "goto_mainmenu":
//                    text = "com.mytgbot.Main menu";
//                    inlineKeyboardMarkup = getMainMenuInlineKeyboard();
//                    break;
//            }
//
//            EditMessageText message = new EditMessageText();
//            message.setChatId(chatId);
//            message.setMessageId(messageId);
//            message.setText(text);
//            message.setReplyMarkup(inlineKeyboardMarkup);
//
//            try {
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }

        }
    }

    private InlineKeyboardMarkup getMainMenuInlineKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Goto A");
        button.setCallbackData("goto_a");
        row.add(button);

        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Goto B");
        button.setCallbackData("goto_b");
        row.add(button);

        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    private InlineKeyboardMarkup getMenuAInlineKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Goto AA");
        button.setCallbackData("goto_a_a");
        row.add(button);

        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Goto MainMenu");
        button.setCallbackData("goto_mainmenu");
        row.add(button);

        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    private InlineKeyboardMarkup getMenuBInlineKeyboard() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Goto BB");
        button.setCallbackData("goto_b_b");
        row.add(button);

        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText("Goto MainMenu");
        button.setCallbackData("goto_mainmenu");
        row.add(button);

        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

}
