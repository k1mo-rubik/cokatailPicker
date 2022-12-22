package ru.cocktails.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cocktails.core.entity.Room;
import ru.cocktails.core.mapper.RoomMapper;
import ru.cocktails.core.model.RoomDto;
import ru.cocktails.core.repository.RoomRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public Room findById(String name) {
        return roomRepository.findByName(name).orElse(null);
    }

    public void save(RoomDto roomDto) {
        Room room = roomMapper.map(roomDto);
        roomRepository.save(room);
    }

    public Room findById(UUID id) {
        return roomRepository.findById(id).orElse(null);
    }
}
