package ru.cocktails.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cocktails.core.model.RoomDto;
import ru.cocktails.core.service.RoomService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/room")
    public String getRoom(@RequestBody RoomDto roomDto) {
        log.info("Get room: {}", roomDto);

        return "room";
    }

}
