package com.objetos;

public class Tarjeta {
	private Integer Numero;
	private Usuario Usuario;
	private String Banco;
	protected Double Movimientos;
	private Double Margen;
	
	public Tarjeta(Integer numero) {
		this.Numero = numero;
	}
	
	public Tarjeta(Integer numero, Usuario usuario, String banco, Double movimientos, Double margen) {
		this.Usuario = usuario;
		this.Numero = numero;
		this.Banco = banco;
		this.Movimientos = movimientos;
		this.Margen = margen;
	}

	public Integer getNumero() {
		return Numero;
	}

	public void setNumero(Integer numero) {
		Numero = numero;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public String getBanco() {
		return Banco;
	}

	public void setBanco(String banco) {
		Banco = banco;
	}

	public Double getMovimientos() {
		return Movimientos;
	}

	public void setMovimientos(Double movimientos) {
		Movimientos = movimientos;
	}

	public Double getMargen() {
		return Margen;
	}

	public void setMargen(Double margen) {
		Margen = margen;
	}

}
