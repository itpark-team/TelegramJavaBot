import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegtammBotManagerButtons extends TelegramLongPollingBot {
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

                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("You send /start");

                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                InlineKeyboardButton b1 = new InlineKeyboardButton();
                b1.setText("Update message text");
                b1.setCallbackData("update_msg_text");
                rowInline.add(b1);

                rowsInline.add(rowInline);

                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }
        } else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            int message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (call_data.equals("update_msg_text")) {
                String answer = "Updated message text";
//                EditMessageText new_message = new EditMessageText();
//                new_message.setChatId(chat_id);
//                new_message.setMessageId(message_id);
//                new_message.setText(answer);

                SendMessage message = new SendMessage();
                message.setChatId(chat_id);
                message.setText("You send /start");



                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
