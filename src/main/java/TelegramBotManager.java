import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotManager extends TelegramLongPollingBot {

    private DbJokes dbJokes;

    public TelegramBotManager() {
        dbJokes = new DbJokes();
    }

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

            String chatId = update.getMessage().getChatId().toString();
            String recieveText = update.getMessage().getText();

            String responseText = "";

            if(recieveText.equals("/joke")){
                responseText = dbJokes.getRandomJoke();
            }else{
                responseText = "Ошибка. Команда не распознана. Введите /joke для получения случайной шутки";
            }

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(responseText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
