package pet.coffeemash.repository;

import org.springframework.data.repository.CrudRepository;
import pet.coffeemash.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
