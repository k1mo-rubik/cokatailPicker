package ru.cocktails.core.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cocktails.core.entity.Cocktail;
import ru.cocktails.core.entity.Room;
import ru.cocktails.core.model.RoomDto;
import ru.cocktails.core.service.CocktailService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomMapper {

    private final CocktailService cocktailService;

    public Room map(RoomDto roomDto) {
        Room room = new Room();
        for (String cocktailName : roomDto.getCocktails()) {
            Cocktail cocktail = cocktailService.findByName(cocktailName);
            if (cocktail != null) {
                room.addCocktail(cocktailService.findByName(cocktailName));
            }
        }
        room.setId(UUID.randomUUID());
        room.setName(roomDto.getName());
        return room;
    }

}
