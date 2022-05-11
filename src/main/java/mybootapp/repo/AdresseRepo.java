package mybootapp.repo;

import mybootapp.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepo extends JpaRepository<Adresse, Long> {
}
