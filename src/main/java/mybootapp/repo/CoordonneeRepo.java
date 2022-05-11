package mybootapp.repo;

import mybootapp.model.Coordonnee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordonneeRepo extends JpaRepository<Coordonnee, Long> {
}
