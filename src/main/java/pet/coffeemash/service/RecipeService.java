package pet.coffeemash.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.coffeemash.dto.RecipeDto;
import pet.coffeemash.model.Recipe;
import pet.coffeemash.repository.RecipeRepository;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;

    public Recipe addRecipe(RecipeDto recipeDto) {
        var recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        return recipeRepository.save(recipe);
    }
}
