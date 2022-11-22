package ru.cocktails;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingCommandBot {

    private final String token;
    private final String name;

    public Bot(String token, String name) {
        super();
        this.name = name;
        this.token = token;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }
}
