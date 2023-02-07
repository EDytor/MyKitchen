package pl.mykitchen.mykitchen.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class ShoppingListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Ingredient ingredient;
    private BigDecimal amount;

    public ShoppingListItem(Ingredient ingredient, BigDecimal amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public ShoppingListItem() {
    }

    public ShoppingListItem(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
