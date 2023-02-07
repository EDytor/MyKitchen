package pl.mykitchen.mykitchen.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import pl.mykitchen.mykitchen.domain.UnitOfMeasure;
import pl.mykitchen.mykitchen.repositories.UnitOfMeasureRepository;

public class UnitOfMeasureBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureBootstrap(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UnitOfMeasure glass1 = new UnitOfMeasure();
        glass1.setDescription("glass");
        unitOfMeasureRepository.save(glass1);

        UnitOfMeasure spoon1 = new UnitOfMeasure();
        spoon1.setDescription("spoon");
        unitOfMeasureRepository.save(spoon1);

        UnitOfMeasure gram = new UnitOfMeasure();
        gram.setDescription("gram");
        unitOfMeasureRepository.save(gram);
    }
}

