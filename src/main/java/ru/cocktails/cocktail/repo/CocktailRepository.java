package ru.cocktails.cocktail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cocktails.cocktail.model.entity.Cocktail;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {

}
