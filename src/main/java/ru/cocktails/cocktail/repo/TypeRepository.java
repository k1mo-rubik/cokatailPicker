package ru.cocktails.cocktail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cocktails.cocktail.model.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

}
