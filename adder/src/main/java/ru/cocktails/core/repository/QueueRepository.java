package ru.cocktails.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cocktails.core.entity.Queue;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {

}
