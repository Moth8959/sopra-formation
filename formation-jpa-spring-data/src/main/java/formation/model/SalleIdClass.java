package formation.model;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//@Entity
@Table(name = "classroom")
@IdClass(SalleId.class)
public class SalleIdClass {
	@Id
	private Integer etage;
	@Id
	private String nom;
	private Integer capacite;

	public SalleIdClass() {
		super();
	}

	public SalleIdClass(Integer etage, String nom) {
		this(etage, nom, null);
	}

	public SalleIdClass(Integer etage, String nom, Integer capacite) {
		super();
		this.etage = etage;
		this.nom = nom;
		this.capacite = capacite;
	}

	public Integer getEtage() {
		return etage;
	}

	public void setEtage(Integer etage) {
		this.etage = etage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

}
