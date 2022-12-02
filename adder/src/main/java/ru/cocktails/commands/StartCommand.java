package ru.cocktails.commands;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.cocktails.buttons.BotButtons;
import ru.cocktails.core.entity.Customer;
import ru.cocktails.core.service.CustomerService;

import java.util.UUID;

@Slf4j
public class StartCommand extends ServiceCommand {

    private final CustomerService customerService;

    public StartCommand(String commandIdentifier, String description, CustomerService customerService) {
        super(commandIdentifier, description);
        this.customerService = customerService;
    }

    @SneakyThrows
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(false);
        message.setChatId(String.valueOf(chat.getId()));
        message.setText("Добро пожаловать в Cocktails Bot! Введи идентификатор комнаты");
        registerCustomer(user, chat);

        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            log.error("Cannot send message with such parameters chatId: {}, userName: {}",
                    chat.getId(), chat.getUserName());
            throw new TelegramApiException(e);
        }

    }

    private void registerCustomer(User user, Chat chat) {
        if (customerService.findById(chat.getId()) == null) {
            Customer customer = new Customer();
            customer.setChatId(chat.getId());
            customer.setName(user.getFirstName());
            customer.setId(UUID.randomUUID());
            customerService.save(customer);
        }
    }

}
