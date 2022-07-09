package clases;

public class Domicilio {
	private String Localidad;
	private String Barrio;
	private String Calle;
	private Integer NumCasa;
	private Integer NumPiso;
	private Integer NumDpto;
	
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getBarrio() {
		return Barrio;
	}
	public void setBarrio(String barrio) {
		Barrio = barrio;
	}
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		this.Calle = calle;
	}
	public Integer getNumCasa() {
		return NumCasa;
	}
	public void setNumCasa(Integer numCasa) {
		NumCasa = numCasa;
	}
	public Integer getNumPiso() {
		return NumPiso;
	}
	public void setNumPiso(Integer numPiso) {
		NumPiso = numPiso;
	}
	public Integer getNumDpto() {
		return NumDpto;
	}
	public void setNumDpto(Integer numDpto) {
		NumDpto = numDpto;
	}

}
