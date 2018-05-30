package formation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class SalleId implements Serializable {
	@Column(name="floor")
	private Integer etage;
	@Column(name="name", length=100)
	private String nom;

	public SalleId() {
		super();
	}

	public SalleId(Integer etage, String nom) {
		super();
		this.etage = etage;
		this.nom = nom;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etage == null) ? 0 : etage.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalleId other = (SalleId) obj;
		if (etage == null) {
			if (other.etage != null)
				return false;
		} else if (!etage.equals(other.etage))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
}
