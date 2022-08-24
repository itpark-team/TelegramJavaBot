import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

//        Chainclass chainclass = new Chainclass();
//        chainclass.setChatId(10);
//        chainclass.setMessage("sdsdsd");

//        Chainclass chainclass = new Chainclass();
//        chainclass.setChatId(10).setMessage("sddss");
//

        Chainclass chainclass = new Chainclass().setChatId(10).setMessage("sddss");

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            //botsApi.registerBot(new TelegramBotManager());
            //botsApi.registerBot(new TelegtammBotManagerButtons());

            //TgBotButtons2 tgBotButtons2 = new TgBotButtons2();
            //botsApi.registerBot(tgBotButtons2);

            //botsApi.registerBot(new TgInlineKeyboardSample());
            //botsApi.registerBot(new TgSendPhoto());
            //botsApi.registerBot(new TgParseComplexCommand());
            //botsApi.registerBot(new TgKeyboardSample());
            botsApi.registerBot(new TgMultiLevelMenu());


//            SharedResourceManager sharedResourceManager = new SharedResourceManager();
//            botsApi.registerBot(new TgSharedResource(sharedResourceManager));


            System.out.println("bot started");

            //tgBotButtons2.sendFirstMessage();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
