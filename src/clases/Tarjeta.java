package clases;

import java.sql.Date;

public class Tarjeta {
	private Long Numero_tarjeta;
	private Integer Codigo_seguridad;
	private Date Vencimiento;
	private Cliente Titular;
	private Float Saldo;
	private String Tipo;
	
	public Long getNumero_tarjeta() {
		return Numero_tarjeta;
	}
	public void setNumero_tarjeta(Long numero_tarjeta) {
		Numero_tarjeta = numero_tarjeta;
	}
	public Integer getCodigo_seguridad() {
		return Codigo_seguridad;
	}
	public void setCodigo_seguridad(Integer codigo_seguridad) {
		Codigo_seguridad = codigo_seguridad;
	}
	public Date getVencimiento() {
		return Vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		Vencimiento = vencimiento;
	}
	public Cliente getTitular() {
		return Titular;
	}
	public void setTitular(Cliente titular) {
		Titular = titular;
	}
	public Float getSaldo() {
		return Saldo;
	}
	public void setSaldo(Float saldo) {
		Saldo = saldo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
}
