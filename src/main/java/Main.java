import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            //botsApi.registerBot(new TelegramBotManager());
            //botsApi.registerBot(new TelegtammBotManagerButtons());

            //TgBotButtons2 tgBotButtons2 = new TgBotButtons2();
            //botsApi.registerBot(tgBotButtons2);

            botsApi.registerBot(new TgInlineKeyboardSample());
            //botsApi.registerBot(new TgKeyboardSample());

            System.out.println("bot started");

            //tgBotButtons2.sendFirstMessage();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
