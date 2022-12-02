package ru.cocktails.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cocktails.core.entity.Room;
import ru.cocktails.core.repository.RoomRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public Room findById(String name) {
        return roomRepository.findByName(name).orElse(null);
    }
}
