package com.objetos;

import java.sql.Date;

public class Usuario {
	private Integer Id_usuario;
	private String Nombre;
	private String Apellido;
	private String Email;
	private String Clave;
	private Date Fecha_de_nacimiento;
	private Domicilio Domicilio;
	
	public Usuario(String nombre, String apellido, String email, String clave, Date fecha_de_nacimiento, Domicilio domicilio) {
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Clave = clave;
		Fecha_de_nacimiento = fecha_de_nacimiento;
		Domicilio = domicilio;
	}
	
	public Usuario(Integer id, String nombre, String apellido, String email, Date fecha_de_nacimiento, String clave, Integer puntos) {
		Id_usuario = id;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
		Fecha_de_nacimiento = fecha_de_nacimiento;
		Clave = clave;
	}
	
	public Usuario(String email, String clave) {
		Email = email;
		Clave = clave;
	}
	
	public Usuario(Integer id, String nombre, String apellido, String email) {
		Id_usuario = id;
		Nombre = nombre;
		Apellido = apellido;
		Email = email;
	}
	
	public Usuario(Integer id) {
		Id_usuario = id;
	}

	public Integer getId_usuario() {
		return Id_usuario;
	}
	public Date getFecha_de_nacimiento() {
		return Fecha_de_nacimiento;
	}
	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		Fecha_de_nacimiento = fecha_de_nacimiento;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEmail() {
		return Email;
	}
	public String getClave() {
		return Clave;
	}
	public Domicilio getDomicilio() {
		return Domicilio;
	}
	public void setId_usuario(Integer id_usuario) {
		Id_usuario = id_usuario;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public void setDomicilio(Domicilio domicilio) {
		Domicilio = domicilio;
	}
}
