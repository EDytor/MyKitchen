package pl.mykitchen.mykitchen.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mykitchen.mykitchen.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}