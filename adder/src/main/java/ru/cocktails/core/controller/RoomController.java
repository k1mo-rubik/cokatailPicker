package ru.cocktails.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cocktails.core.mapper.RoomMapper;
import ru.cocktails.core.model.RoomDto;
import ru.cocktails.core.service.RoomService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<String> getRoom(@RequestBody RoomDto roomDto) {
        log.info("Get room: {}", roomDto);
        roomService.save(roomDto);
        return ResponseEntity.ok("success");
    }

}
