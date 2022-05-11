package mybootapp.repo;

import mybootapp.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepo extends JpaRepository<Action, Long> {
}
