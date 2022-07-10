package com.cruds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.objetos.Conector;
import com.objetos.Domicilio;



public class CrudDomicilio {
	private Conector conexion;
	private String sql;

	public CrudDomicilio () {
		super();
		this.conexion = new Conector();
		this.conexion.connect(); // Abre la conexion
		this.sql = " ";
	}
	
	public Domicilio RegistrarDomicilio (Domicilio domicilio) { // Registrar domicilio
		this.sql = "INSERT INTO domicilio \r\n"
	            + "(localidad, barrio, calle) \r\n"
				+ "VALUES"
				+ "('" + domicilio.getLocalidad() + "',"
	            + "'" + domicilio.getBarrio()+"',"
	            + "'" + domicilio.getCalle()+"')";
		try {
			PreparedStatement stmt = conexion.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int filas = stmt.executeUpdate();
			if(filas>0) {
				ResultSet rs = stmt.getGeneratedKeys();
				while(rs.next()) {
					domicilio.setId(rs.getInt(1));
				}
			}
			System.out.println("Domicilio registrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return domicilio;
	}
	
	public ArrayList<Domicilio> consultarDomicilios(){
	    ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>();
		this.sql = "SELECT * FROM domicilio";
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Domicilios Registrados en Supermark:");
			ResultSet rs = conexion.getRs();
			try {
				while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
					Domicilio dom = new Domicilio(
							rs.getInt("id"),
							rs.getString("localidad"),
							rs.getString("barrio"),
							rs.getString("calle"),
							rs.getInt("Num_casa"),
							rs.getInt("Num_piso"),
							rs.getInt("Num_depto"));
					domicilios.add(dom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	}
   return domicilios;
}

	public Domicilio getDomicilio(Integer id) {
		this.sql = "SELECT * FROM domicilio "+
				"WHERE domicilio.id="+id;
		Domicilio dom = null;
		try {
			ResultSet rs = conexion.getStmt().executeQuery(sql);
			while (rs.next()) {
	            dom = new Domicilio(
	            		rs.getInt("id"),
	            		rs.getString("localidad"),
	                    rs.getString("barrio"),
	                    rs.getString("calle"),
	                    rs.getInt("Num_casa"),
	                    rs.getInt("Num_piso"),
	                    rs.getInt("Num_depto"));
	     }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dom;
	}
}
