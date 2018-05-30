package formation.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VideoProjecteur")
public class VideoProjecteur extends Ressource {
	private Integer resolution;
	private Boolean hdmi;
	private Boolean vga;

	public VideoProjecteur() {
		super();
	}

	public VideoProjecteur(String code, Integer resolution, Boolean hdmi, Boolean vga) {
		super(code);
		this.resolution = resolution;
		this.hdmi = hdmi;
		this.vga = vga;
	}

	public Integer getResolution() {
		return resolution;
	}

	public void setResolution(Integer resolution) {
		this.resolution = resolution;
	}

	public Boolean getHdmi() {
		return hdmi;
	}

	public void setHdmi(Boolean hdmi) {
		this.hdmi = hdmi;
	}

	public Boolean getVga() {
		return vga;
	}

	public void setVga(Boolean vga) {
		this.vga = vga;
	}

}
