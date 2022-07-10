package com.supermark_g14_ct4;

import com.google.gson.JsonElement;

public class StandardResponse {
	private StatusResponse estado;
	private String mensaje;
	private JsonElement datos;
	
	public StandardResponse(StatusResponse status) {
		this.estado = status;
	}
	public StandardResponse(StatusResponse status, String mensaje) {
		this.estado = status;
		this.mensaje = mensaje;
	}
	public StandardResponse(StatusResponse status, JsonElement datos) {
		this.estado = status;
		this.datos = datos;
	}
	public StatusResponse getEstado() {
		return estado;
	}
	public void setEstado(StatusResponse estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public JsonElement getDatos() {
		return datos;
	}
	public void setDatos(JsonElement datos) {
		this.datos = datos;
	}
	
	

}
