package pet.coffeemash.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pet.coffeemash.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT recipe_id FROM orders GROUP BY recipe_id ORDER BY COUNT(recipe_id) DESC LIMIT 1", nativeQuery = true)
    Long findMostPopularRecipe();
}
