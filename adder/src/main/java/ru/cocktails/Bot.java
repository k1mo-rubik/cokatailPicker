package ru.cocktails;

import lombok.SneakyThrows;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.cocktails.buttons.BotButtons;
import ru.cocktails.commands.StartCommand;
import ru.cocktails.core.entity.Cocktail;
import ru.cocktails.core.entity.Customer;
import ru.cocktails.core.entity.Room;
import ru.cocktails.core.service.CustomerService;
import ru.cocktails.core.service.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Bot extends TelegramLongPollingCommandBot {

    private final String token;
    private final String name;

    private final CustomerService customerService;
    private final RoomService roomService;

    public Bot(String token, String name, CustomerService customerService, RoomService roomService) {
        super();
        this.name = name;
        this.token = token;
        register(new StartCommand("start", "Start command", customerService));
        this.customerService = customerService;
        this.roomService = roomService;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @SneakyThrows
    @Override
    public void processNonCommandUpdate(Update update) {
        Customer customer = customerService.findById(update.getMessage().getFrom().getId());
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());
        if (customer.getRoom() == null) {
            Room room = roomService.findById(update.getMessage().getText());
            if (room == null) {
                message.setText("Комната не найдена либо идентификатор введен неверно");
                execute(message);
                return;
            }
            message.setText("Вы успешно подключились к комнате " + room.getName() + "\n Теперь определите вашу роль");
            message.setReplyMarkup(BotButtons.getRoleButtons());
            customer.setRoom(room);
            customerService.save(customer);
            execute(message);
        } else if (customer.getRole() == null) {
            if (validateRole(update.getMessage().getText())) {
                customer.setRole(update.getMessage().getText());
                customerService.save(customer);
                message.setText("Отлично! Приятного вечера!" + getMessageOnRole(update.getMessage().getText()));
                message.setReplyMarkup(getCockTailsButtons(customer.getRoom()));
                execute(message);
            } else {
                message.setText("Роль введена неверно");
                message.setReplyMarkup(BotButtons.getRoleButtons());
                execute(message);
            }
        } else if (customer.getRole().equals("Заказывающий")) {
            Room room = roomService.findById(customer.getRoom().getId());

        }
    }

    private Boolean validateRole(String role) {
        return role.equals("Бармен") || role.equals("Заказывающий");
    }

    private String getMessageOnRole(String role) {
        if (role.equals("Бармен")) {
            return " Вскоре вы начнёте получать заказы коктейлей. Сил вам!";
        } else{
            return " Выбирайте интересующий вас коктейль из списка. Бармен по-возможности приготовит его для вас";
        }

    }

    private ReplyKeyboardMarkup getCockTailsButtons(Room room) {
        ReplyKeyboardMarkup replyKeyboardMarkupMain  = new ReplyKeyboardMarkup();
        replyKeyboardMarkupMain.setSelective(true);
        replyKeyboardMarkupMain.setResizeKeyboard(true);
        replyKeyboardMarkupMain.setOneTimeKeyboard(false);

        KeyboardRow firstRow = new KeyboardRow();
        Set<Cocktail> cocktails = room.getCocktailRooms();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        int flag = 1;
        for (Cocktail cocktail : cocktails) {
            if(flag == 2) {
                keyboardRowList.add(firstRow);
                firstRow = new KeyboardRow();
                flag = 0;
            }
            flag++;
            firstRow.add(cocktail.getName());
        }
        replyKeyboardMarkupMain.setKeyboard(keyboardRowList);
        return replyKeyboardMarkupMain;
    }

}
