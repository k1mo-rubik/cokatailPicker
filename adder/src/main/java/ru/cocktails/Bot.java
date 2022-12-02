package ru.cocktails;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.cocktails.commands.StartCommand;
import ru.cocktails.core.service.CustomerService;

public class Bot extends TelegramLongPollingCommandBot {

    private final String token;
    private final String name;

    public Bot(String token, String name, CustomerService customerService) {
        super();
        this.name = name;
        this.token = token;
        register(new StartCommand("start", "Start command", customerService));
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
