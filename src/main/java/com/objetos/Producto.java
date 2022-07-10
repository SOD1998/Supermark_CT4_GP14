package com.objetos;

import java.sql.Date;

public class Producto {
	private Integer Id_Producto;
	private String Nombre;
	private String Marca;
	private Date Vencimiento;
	private Float Precio_unitario;
	private Integer Stock;
	
	public Producto(Integer id, String nombre, String marca, Date vencimiento, Integer stock, Float precio) {
		this.Id_Producto = id;
		this.Nombre = nombre;
		this.Marca = marca;
		this.Vencimiento = vencimiento;
		this.Precio_unitario = precio;
		this.Stock = stock;
	}
	
	public Producto(String nombre, String marca, Date vencimiento, Float precio, Integer stock) {
		this.Nombre = nombre;
		this.Marca = marca;
		//this.Vencimiento = vencimiento;
		this.Precio_unitario = precio;
		this.Stock = stock;
	}
	
	public Producto(Integer id, String marca, Date vencimiento, Float precio, Integer stock) {
		this.Id_Producto = id;
		this.Marca = marca;
		this.Vencimiento = vencimiento;
		this.Precio_unitario = precio;
		this.Stock = stock;
	}
	
	public Producto(Integer id, String nombre, Float precio) {
		this.Id_Producto = id;
		this.Nombre = nombre;
		this.Precio_unitario = precio;
	}
	
	public Producto(Integer id) {
		this.Id_Producto = id;
	}
	
	public Producto(Integer id, Integer stock) {
		this.Id_Producto = id;
		this.Stock = stock;
	}
	
	public Integer getId_Producto() {
		return Id_Producto;
	}

	public String getNombre() {
		return this.Nombre;
	}
	
	public Float getPrecio_unitario() {
		return this.Precio_unitario;
	}
	
	public Integer getStock() {
		return this.Stock;
	}
	
	public void setId_Producto(Integer id_Producto) {
		Id_Producto = id_Producto;
	}
		
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public void setPrecio_unitario(Float precio_unitario) {
		Precio_unitario = precio_unitario;
	}
	
	public void setStock(Integer stock) {
		Stock = stock;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public Date getVencimiento() {
		return Vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		Vencimiento = vencimiento;
	}

	@Override
	public String toString() {
		return "Producto [Id_Producto=" + Id_Producto + ", Nombre=" + Nombre + ", Marca=" + Marca + ", Vencimiento="
				+ Vencimiento + ", Precio_unitario=" + Precio_unitario + ", Stock=" + Stock + "]";
	}
	
}
