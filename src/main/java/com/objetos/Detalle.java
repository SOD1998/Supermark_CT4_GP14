package com.objetos;

public class Detalle {
	private Producto descripcion;
	private Integer cantidad;
	
	public Detalle(Producto producto, Integer cantidad) {
		this.descripcion = producto;
		this.cantidad = cantidad;
	}
	public Detalle(Integer cantidad, Producto producto) {
		this.descripcion = producto;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Detalle [descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
	}
	public Producto getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(Producto descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}	
}
