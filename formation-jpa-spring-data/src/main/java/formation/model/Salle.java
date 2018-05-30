package formation.model;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "classroom")
public class Salle {
	@EmbeddedId
	private SalleId id;
	@Version
	private int version;
	@Basic(fetch = FetchType.LAZY) // ignorer par Hibernate
	private Integer capacite;
	@Embedded
	private Adresse adr;
	@OneToOne(mappedBy = "salle")
	private Formation formation;

	public Salle() {
		super();
	}

	public Salle(Integer etage, String nom) {
		this(etage, nom, null);
	}

	public Salle(Integer etage, String nom, Integer capacite) {
		super();
		this.id = new SalleId(etage, nom);
		this.capacite = capacite;
	}

	public SalleId getId() {
		return id;
	}

	public void setId(SalleId id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Adresse getAdr() {
		return adr;
	}

	public void setAdr(Adresse adr) {
		this.adr = adr;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
