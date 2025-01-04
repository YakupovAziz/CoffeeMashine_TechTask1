package pet.coffeemash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="recipe")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}