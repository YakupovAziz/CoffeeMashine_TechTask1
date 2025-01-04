package pet.coffeemash.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pet.coffeemash.dto.OrderDto;
import pet.coffeemash.model.Order;
import pet.coffeemash.repository.OrderRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public String findPopularRecipe() {
        return "Popular Recipes";
    }

    public void addOrder(OrderDto orderDto) {
        var order = new Order();
        order.setDate(LocalDateTime.now());
        order.setRecipeId(orderDto.getRecipeId());
        orderRepository.save(order);
    }
}
