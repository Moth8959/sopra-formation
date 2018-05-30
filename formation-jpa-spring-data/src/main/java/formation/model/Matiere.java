package formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "subject")
public class Matiere {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "name", length = 100)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "complexity", length = 100)
	private Complexite complexite;
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date dtDebut;
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date dtFin;

	public Matiere() {
		super();
	}

	public Matiere(String nom, Complexite complexite, Date dtDebut, Date dtFin) {
		super();
		this.nom = nom;
		this.complexite = complexite;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
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

	public Complexite getComplexite() {
		return complexite;
	}

	public void setComplexite(Complexite complexite) {
		this.complexite = complexite;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Date getDtFin() {
		return dtFin;
	}

	public void setDtFin(Date dtFin) {
		this.dtFin = dtFin;
	}

}
