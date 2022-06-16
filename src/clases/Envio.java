package clases;

public class Envio {
	private Integer Id_envio;
	private Domicilio Domicilio;
	private Float Costo_de_envio;
	private Carrito Carrito;
	
	public Integer getId_envio() {
		return Id_envio;
	}
	public void setId_envio(Integer id_envio) {
		Id_envio = id_envio;
	}
	public Domicilio getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		Domicilio = domicilio;
	}
	public Float getCosto_de_envio() {
		return Costo_de_envio;
	}
	public void setCosto_de_envio(Float costo_de_envio) {
		Costo_de_envio = costo_de_envio;
	}
	public Carrito getCarrito() {
		return Carrito;
	}
	public void setCarrito(Carrito carrito) {
		Carrito = carrito;
	}
	
	

}
