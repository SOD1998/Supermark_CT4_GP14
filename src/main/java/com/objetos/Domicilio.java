package com.objetos;

public class Domicilio {
	private Integer Id;
	private String Localidad;
	private String Barrio;
	private String Calle;
	private Integer NumCasa;
	private Integer NumPiso;
	private Integer NumDpto;
	
	public Domicilio(String localidad, String barrio, String calle) {
		this.Localidad = localidad;
		this.Barrio = barrio;
		this.Calle = calle;
	}
	
	public Domicilio(Integer id, String localidad, String barrio, String calle) {
		this.Id = id;
		this.Localidad = localidad;
		this.Barrio = barrio;
		this.Calle = calle;
	}
	
	public Domicilio(String localidad, String barrio, String calle, Integer casa) {
		this.Localidad = localidad;
		this.Barrio = barrio;
		this.Calle = calle;
		this.NumCasa = casa;
	}
	
	public Domicilio(String localidad, String barrio, String calle, Integer piso, Integer dpto) {
		this.Localidad = localidad;
		this.Barrio = barrio;
		this.Calle = calle;
		this.NumPiso = piso;
		this.NumDpto = dpto;
	}
	
	public Domicilio(Integer id, String localidad, String barrio, String calle, Integer casa,Integer piso, Integer dpto) {
		this.Id = id;
		this.Localidad = localidad;
		this.Barrio = barrio;
		this.Calle = calle;
		this.NumCasa = casa;
		this.NumPiso = piso;
		this.NumDpto = dpto;
	}
	
	public Domicilio(Integer id) {
		this.Id = id;
	}
	
	@Override
	public String toString() {
		return "Domicilio [Id=" + Id + ", Localidad=" + Localidad + ", Barrio=" + Barrio + ", Calle=" + Calle
				+ ", NumCasa=" + NumCasa + ", NumPiso=" + NumPiso + ", NumDpto=" + NumDpto + "]";
	}

	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
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
