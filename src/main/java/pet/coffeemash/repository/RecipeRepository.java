package pet.coffeemash.repository;

import org.springframework.data.repository.CrudRepository;
import pet.coffeemash.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
