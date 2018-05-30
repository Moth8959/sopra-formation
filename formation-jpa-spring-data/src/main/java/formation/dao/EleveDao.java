package formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.model.Eleve;

public interface EleveDao extends JpaRepository<Eleve, Long>{
	List<Eleve> findByNom(String nom);
	
	@Query("select e from Eleve e where e.age = :monAge")
	List<Eleve> searchByAge(@Param("monAge") int age);
}
