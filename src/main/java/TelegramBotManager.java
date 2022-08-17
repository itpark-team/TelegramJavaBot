import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBotManager extends TelegramLongPollingBot {

    //private DbJokes dbJokes;
    private GuessGameLogic guessGameLogic;

    public TelegramBotManager() {
        //dbJokes = new DbJokes();
        guessGameLogic = new GuessGameLogic();
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

            if (recieveText.equals("/start")) {
                guessGameLogic.startNewGame();
                responseText = "Игра началась. Я загадал число от 1 до 100";
            } else {
                try {
                    int userNumber = Integer.parseInt(recieveText);
                    responseText = guessGameLogic.processUserNumber(userNumber);
                } catch (Exception e) {
                    responseText = "ошибка вы ввели не число";
                }
            }


//            if(recieveText.equals("/joke")){
//                responseText = dbJokes.getRandomJoke();
//            }else{
//                responseText = "Ошибка. Команда не распознана. Введите /joke для получения случайной шутки";
//            }

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
