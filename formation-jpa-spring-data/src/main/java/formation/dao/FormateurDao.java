package formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.model.Formateur;

public interface FormateurDao extends JpaRepository<Formateur, Long> {
	@Query(name = "Formateur.findAllByNom")
	List<Formateur> findAllByNom(@Param("recherche") String nom);
	
	@Query("select distinct f from Formateur f where f.nom = :nom")
	Optional<Formateur> findOneByNom(@Param("nom") String nom);

	@Query(name = "Formateur.findAllWithoutEleve")
	List<Formateur> findAllWihoutEleve();
}
