package formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "trainer")
@NamedQueries({
		@NamedQuery(name = "Formateur.findAllByNom", query = "select f from Formateur f where f.nom like :recherche"),
		@NamedQuery(name = "Formateur.findAllWithoutEleve", query = "select f from Formateur f join f.eleves e where e.size = 0") })
public class Formateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "name", length = 100)
	private String nom;
	private Integer experience;
	private Boolean referent;
	@ManyToMany
	@JoinTable(name = "trainer_student", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Eleve> eleves = new ArrayList<>();
	@OneToMany(mappedBy = "formateur")
	private List<Formation> formations = new ArrayList<>();

	public Formateur() {
		super();
	}

	public Formateur(String nom, Integer experience, Boolean referent) {
		super();
		this.nom = nom;
		this.experience = experience;
		this.referent = referent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Boolean getReferent() {
		return referent;
	}

	public void setReferent(Boolean referent) {
		this.referent = referent;
	}

	// public Formateur(Long id, String nom, Integer experience, Boolean referent,
	// Eleve eleve) {
	// super();
	// this.id = id;
	// this.nom = nom;
	// this.experience = experience;
	// this.referent = referent;
	// this.eleve = eleve;
	// }

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	public void addEleve(Eleve eleve) {
		this.eleves.add(eleve);
	}

	public void removeEleve(Eleve eleve) {
		this.eleves.remove(eleve);
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + ", experience=" + experience + ", referent=" + referent + "]";
	}

}
