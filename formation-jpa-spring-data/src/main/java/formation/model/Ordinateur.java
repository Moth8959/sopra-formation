package formation.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Ordinateur")
public class Ordinateur extends Ressource {
	@Column(name = "brand", length = 100)
	private String marque;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private CPU cpu;
	private Integer ram;

	public Ordinateur() {
		super();
	}

	public Ordinateur(String code, String marque, CPU cpu, Integer ram) {
		super(code);
		this.marque = marque;
		this.cpu = cpu;
		this.ram = ram;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(Integer ram) {
		this.ram = ram;
	}

}
