package pl.mykitchen.mykitchen.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mykitchen.mykitchen.repositories.CategoryRepository;
import pl.mykitchen.mykitchen.repositories.UnitRepository;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitRepository unitRepository;

    public IndexController(CategoryRepository categoryRepository, UnitRepository unitRepository) {
        this.categoryRepository = categoryRepository;
        this.unitRepository = unitRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }
}
