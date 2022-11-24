package pl.mykitchen.mykitchen.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mykitchen.mykitchen.domain.Unit;

import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit, Long> {
    Optional<Unit> findByDescription(String description);
}
