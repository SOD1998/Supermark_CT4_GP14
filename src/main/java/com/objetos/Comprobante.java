package com.objetos;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Comprobante {
	private Integer id;
	private Float total;
	private String tipo;
	private Timestamp fecha;
	private ArrayList<Detalle> detalles;
	private Usuario destinatario;
	private Tarjeta tarjeta;
	private Float descuento;
	
	public Comprobante(String tipo, Timestamp fecha, ArrayList<Detalle> detalles, Usuario destinatario, Tarjeta tarjeta) {
		this.tipo = tipo;
		this.fecha = new Timestamp(System.currentTimeMillis());
		this.detalles = detalles;
		this.destinatario = destinatario;
		this.tarjeta = tarjeta;
	}
	public Comprobante() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
	public Float getDescuento() {
		return descuento;
	}
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
}