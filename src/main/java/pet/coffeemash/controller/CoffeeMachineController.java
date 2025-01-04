package pet.coffeemash.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pet.coffeemash.dto.OrderDto;
import pet.coffeemash.dto.RecipeDto;
import pet.coffeemash.model.Recipe;
import pet.coffeemash.service.OrderService;
import pet.coffeemash.service.RecipeService;

@AllArgsConstructor
@RestController
public class CoffeeMachineController {

    private OrderService orderService;
    private RecipeService recipeService;

    @GetMapping("/statistics/popular")
    public String popularRecipe() {
        return orderService.findPopularRecipe();
    }

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> addRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe savedRecipe = recipeService.addRecipe(recipeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
    }

    @PostMapping("/order")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
