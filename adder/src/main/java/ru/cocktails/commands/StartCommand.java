package ru.cocktails.commands;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.cocktails.buttons.BotButtons;

@Slf4j
public class StartCommand extends ServiceCommand {

    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @SneakyThrows
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(false);
        message.setChatId(String.valueOf(chat.getId()));
        message.setText("Добро пожаловать в Cocktails Bot! Введи идентификатор комнаты");
        message.setReplyMarkup(BotButtons.getMainButtons());

        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            log.error("Cannot send message with such parameters chatId: {}, userName: {}",
                    chat.getId(), chat.getUserName());
            throw new TelegramApiException(e);
        }

    }

}
