package pl.mykitchen.mykitchen.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    private Integer cookTime;

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))

    private Set<Category> categories = new HashSet<>();

    @Lob
    private Byte[] image;
}
