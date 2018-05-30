package formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.model.Ordinateur;
import formation.model.Ressource;
import formation.model.VideoProjecteur;

public interface RessourceDao extends JpaRepository<Ressource, Long> {
	@Query("select o from Ordinateur o")
	List<Ordinateur> findAllOrdinateur();
	@Query("select vp from VideoProjecteur vp")
	List<VideoProjecteur> findAllVideoProjecteur();
}
