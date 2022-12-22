package pl.mykitchen.mykitchen.bootstrap;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.mykitchen.mykitchen.domain.Category;
import pl.mykitchen.mykitchen.repositories.CategoryRepository;


@Component
public class CategoryBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    CategoryRepository categoryRepository;

    public CategoryBootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Category category1 = new Category();
        category1.setDescription("Wegetariańskie");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setDescription("Mięsne");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setDescription("Deser");
        categoryRepository.save(category3);

        Category category = new Category();
        category.setDescription("Makarony");
        categoryRepository.save(category);


    }
}
