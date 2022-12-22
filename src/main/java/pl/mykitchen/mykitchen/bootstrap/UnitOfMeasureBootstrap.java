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
        glass1.setDescription("szklanka");
        unitOfMeasureRepository.save(glass1);

        UnitOfMeasure glass2 = new UnitOfMeasure();
        glass2.setDescription("szklanki");
        unitOfMeasureRepository.save(glass2);

        UnitOfMeasure glass3 = new UnitOfMeasure();
        glass3.setDescription("szklanek");
        unitOfMeasureRepository.save(glass3);

        UnitOfMeasure spoon1 = new UnitOfMeasure();
        spoon1.setDescription("łyżka");
        unitOfMeasureRepository.save(spoon1);

        UnitOfMeasure spoon2 = new UnitOfMeasure();
        spoon2.setDescription("łyżek");
        unitOfMeasureRepository.save(spoon2);

        UnitOfMeasure spoon3 = new UnitOfMeasure();
        spoon3.setDescription("łyżki");
        unitOfMeasureRepository.save(spoon3);

        UnitOfMeasure gram = new UnitOfMeasure();
        gram.setDescription("gram");
        unitOfMeasureRepository.save(gram);
    }
}

