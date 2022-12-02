package ru.cocktails.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.cocktails.Bot;
import ru.cocktails.core.service.CustomerService;
import ru.cocktails.core.service.RoomService;

@Configuration
public class TelegramBotConfiguration {

    @Bean
    public Bot telegramBot(
            @Value("${bot.name}") String name,
            @Value("${bot.token}") String token,
            CustomerService customerService,
            RoomService roomService) {
        return new Bot(token, name, customerService, roomService);
    }

    @Bean
    public TelegramBotsApi telegramBotsApi(Bot bot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
        return telegramBotsApi;
    }

}
