package pet.coffeemash.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pet.coffeemash.dto.OrderDto;
import pet.coffeemash.hundler.WorkingHoursException;
import pet.coffeemash.model.Order;
import pet.coffeemash.repository.OrderRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private OperationalService operationalService;

    public ResponseEntity<Long> findPopularRecipe() {
        return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findMostPopularRecipe());
    }

    public void addOrder(OrderDto orderDto) {

        if (!operationalService.isWorkingHours()) {
            throw new WorkingHoursException("Not working hours");
        } else {
            var order = new Order();
            order.setDate(LocalDateTime.now());
            order.setRecipeId(orderDto.getRecipeId());
            orderRepository.save(order);
        }
    }
}
