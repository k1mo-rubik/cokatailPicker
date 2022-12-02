package ru.cocktails.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cocktails.core.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}

