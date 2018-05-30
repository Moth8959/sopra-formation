package formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.model.Salle;
import formation.model.SalleId;

public interface SalleDao extends JpaRepository<Salle, SalleId>{
	
}
