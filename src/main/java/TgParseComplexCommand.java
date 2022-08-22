import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TgParseComplexCommand extends TelegramLongPollingBot {
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
            long chatId = update.getMessage().getChatId();
            // /calc 2+5
            if (messageFromBot.startsWith("/calc")) {
                String expression = messageFromBot.substring(messageFromBot.indexOf(" ") + 1);

                Pattern pattern = Pattern.compile("([0-9]+)([\\+,\\-,\\*,\\/])([0-9]+)");
                Matcher matcher = pattern.matcher(expression);

                matcher.find();

                int number1 = Integer.parseInt(matcher.group(1));
                String sign = matcher.group(2);
                int number2 = Integer.parseInt(matcher.group(3));

                int result = 0;

                switch (sign) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        result = number1 / number2;
                        break;
                }

                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText(Integer.toString(result));

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
