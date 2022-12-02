package ru.cocktails.core.model;

import lombok.Data;

import java.util.List;

@Data
public class RoomDto {
    private String name;
    List<String> cocktails;
}
