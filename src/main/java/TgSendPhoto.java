import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TgSendPhoto extends TelegramLongPollingBot {
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
                try {
                    SendPhoto sendPhoto = new SendPhoto();

                    InputFile inputFile = new InputFile(new File("smile.png"));


                    sendPhoto.setChatId(chat_id);
                    sendPhoto.setPhoto(inputFile);


                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
