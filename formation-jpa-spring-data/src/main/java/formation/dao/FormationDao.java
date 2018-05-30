package formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.model.Formation;

public interface FormationDao extends JpaRepository<Formation, Long> {
	@Query("select f from Formation f join fetch f.formateur ff where f.id = :id")
	Formation findOneWithFormateur(@Param("id") Long id);
}
