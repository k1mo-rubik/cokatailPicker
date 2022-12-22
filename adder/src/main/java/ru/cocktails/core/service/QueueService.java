package ru.cocktails.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cocktails.core.repository.QueueRepository;

@Service
@RequiredArgsConstructor
public class QueueService {

    private final QueueRepository queueRepository;
}
