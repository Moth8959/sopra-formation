package formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.model.Matiere;

public interface MatiereDao extends JpaRepository<Matiere, Long>{
	
}
