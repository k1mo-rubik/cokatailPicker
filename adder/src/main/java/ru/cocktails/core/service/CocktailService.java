package ru.cocktails.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cocktails.core.entity.Cocktail;
import ru.cocktails.core.repository.CocktailRepository;

@Service
@RequiredArgsConstructor
public class CocktailService {

    private final CocktailRepository cocktailRepository;

    public Cocktail findByName(String name) {
        return cocktailRepository.findByName(name).orElse(null);
    }

}
