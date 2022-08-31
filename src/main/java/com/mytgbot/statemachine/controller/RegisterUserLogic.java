package com.mytgbot.statemachine.controller;

import com.mytgbot.statemachine.model.DataStorageKeys;
import com.mytgbot.statemachine.model.TransmittedData;
import com.mytgbot.statemachine.model.User;
import com.mytgbot.statemachine.util.SystemState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RegisterUserLogic {
    public void processName(TransmittedData transmittedData, TelegramLongPollingBot bot, long chatId, Update update) {
        String receivedMessage = update.getMessage().getText();
        String responseMessage = "";

        if (receivedMessage.equals("/reset")) {
            responseMessage = "Регистрация сброшена. Для начала регистрации введите /start";
            transmittedData.setSystemState(SystemState.PROCESS_START);
        } else if (receivedMessage.length() >= 2 && receivedMessage.length() <= 32) {

            User user = (User) transmittedData.getDataStorage().get(DataStorageKeys.USER);
            user.setName(receivedMessage);

            responseMessage = "Отлично имя записно.\nВведите Ваш возраст:";

            transmittedData.setSystemState(SystemState.PROCESS_AGE);
        } else {
            responseMessage = "Имя не распознано. Длина имени должна быть от 2 до 32 символов. Повторите Ваш ввод";
        }

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(responseMessage);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void processAge(TransmittedData transmittedData, TelegramLongPollingBot bot, long chatId, Update update) {
        String receivedMessage = update.getMessage().getText();
        String responseMessage = "";

        int age = -1;
        try {
            age = Integer.parseInt(receivedMessage);
        } catch (Exception e) {
        }


        if (receivedMessage.equals("/reset")) {
            responseMessage = "Регистрация сброшена. Для начала регистрации введите /start";
            transmittedData.setSystemState(SystemState.PROCESS_START);
        } else if (age >= 14 && age <= 90) {

            User user = (User) transmittedData.getDataStorage().get(DataStorageKeys.USER);
            user.setAge(age);

            responseMessage = "Отлично возраст записан.\nВведите Ваш город:";

            transmittedData.setSystemState(SystemState.PROCESS_CITY);
        } else {
            responseMessage = "Возраст не распознан. Проверьте, что возраст это число от 14 до 90. Повторите Ваш ввод";
        }

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(responseMessage);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void processCity(TransmittedData transmittedData, TelegramLongPollingBot bot, long chatId, Update update) {
        String receivedMessage = update.getMessage().getText();
        String responseMessage = "";


        if (receivedMessage.equals("/reset")) {
            responseMessage = "Регистрация сброшена. Для начала регистрации введите /start";
            transmittedData.setSystemState(SystemState.PROCESS_START);
        } else if (receivedMessage.length() >= 2 && receivedMessage.length() <= 32) {

            User user = (User) transmittedData.getDataStorage().get(DataStorageKeys.USER);
            user.setCity(receivedMessage);

            responseMessage = String.format("Отлично город записан.\nВаша регистрация закончена.\nПроверьте ваши данные\n%s\nДля регистрации нового человека введите /start", user.toString());

            transmittedData.setSystemState(SystemState.PROCESS_START);
        } else {
            responseMessage = "Город не распознан. Длина города должна быть от 2 до 32 символов. Повторите Ваш ввод";
        }

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(responseMessage);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
