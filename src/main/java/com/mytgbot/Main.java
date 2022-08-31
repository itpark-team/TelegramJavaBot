package com.mytgbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {
    public static void main(String[] args) {

//        com.mytgbot.Chainclass chainclass = new com.mytgbot.Chainclass();
//        chainclass.setChatId(10);
//        chainclass.setMessage("sdsdsd");

//        com.mytgbot.Chainclass chainclass = new com.mytgbot.Chainclass();
//        chainclass.setChatId(10).setMessage("sddss");
//

        Chainclass chainclass = new Chainclass().setChatId(10).setMessage("sddss");

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            //botsApi.registerBot(new com.mytgbot.TelegramBotManager());
            //botsApi.registerBot(new com.mytgbot.TelegtammBotManagerButtons());

            //com.mytgbot.TgBotButtons2 tgBotButtons2 = new com.mytgbot.TgBotButtons2();
            //botsApi.registerBot(tgBotButtons2);

            //botsApi.registerBot(new com.mytgbot.TgInlineKeyboardSample());
            //botsApi.registerBot(new com.mytgbot.TgSendPhoto());
            //botsApi.registerBot(new com.mytgbot.TgParseComplexCommand());
            //botsApi.registerBot(new com.mytgbot.TgKeyboardSample());
            //botsApi.registerBot(new com.mytgbot.TgMultiLevelMenu());
            //botsApi.registerBot(new TelegramBotManager());
            botsApi.registerBot(new TgStateMachine());


//            com.mytgbot.SharedResourceManager sharedResourceManager = new com.mytgbot.SharedResourceManager();
//            botsApi.registerBot(new com.mytgbot.TgSharedResource(sharedResourceManager));


            System.out.println("bot started");

            //tgBotButtons2.sendFirstMessage();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
