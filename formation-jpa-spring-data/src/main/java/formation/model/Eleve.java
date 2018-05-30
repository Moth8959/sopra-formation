package formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "student")
@SecondaryTable(name = "student_lazy")
@SequenceGenerator(name = "seqEleve", sequenceName = "student_sequence")
public class Eleve {
	@Id
	@GeneratedValue(generator = "seqEleve")
	private Long id;
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(name = "civility", length = 10)
	private Civilite civilite;
	@Column(name = "lastname", length = 100)
	private String nom;
	@Column(name = "firstname", length = 100)
	private String prenom;
	private Integer age;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "comments", length = 100, table = "student_lazy")
	private String commentaires;
	// private Formateur formateur;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "rue", column = @Column(name = "st_street", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "st_zipcode", length = 10)),
			@AttributeOverride(name = "ville", column = @Column(name = "st_city", length = 100)) })
	private Adresse adresse;
	@ManyToMany(mappedBy = "eleves")
	private List<Formateur> formateurs = new ArrayList<>();

	public Eleve() {
		super();
	}

	public Eleve(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

}
