package pl.mykitchen.mykitchen.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    Recipe recipe;

    public Ingredient() {
    }
    public Ingredient(String description, UnitOfMeasure uom) {
        this.description = description;
        this.uom = uom;
    }
    public Ingredient(String description, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.uom = uom;
        this.recipe = recipe;
    }
}
