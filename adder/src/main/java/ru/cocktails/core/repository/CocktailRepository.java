package ru.cocktails.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cocktails.core.entity.Cocktail;

import java.util.UUID;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, UUID> {
}
