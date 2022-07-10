package com.cruds;

import java.sql.*;
import java.util.ArrayList;

import com.objetos.Conector;
import com.objetos.Domicilio;
import com.objetos.Usuario;



public class CrudUsuario {
	
	private Conector conexion;
	private String sql;

	public CrudUsuario () {
		super();
		this.conexion = new Conector();
		this.conexion.connect(); // Abre la conexion
		this.sql = " ";
	}
	
	public boolean registrar(Usuario usuario) {//-->Registrar un usuario
		CrudDomicilio cdom = new CrudDomicilio();
		Domicilio dom = cdom.RegistrarDomicilio(usuario.getDomicilio());
		usuario.setDomicilio(dom);
		this.sql = "INSERT INTO Usuario "+
				"(nombre,apellido,email,clave,fecha_de_nacimiento,id_domicilio) "+
				"VALUES"
				+ "('"+ usuario.getNombre() + "',"
				+ "'" + usuario.getApellido() + "',"
				+ "'" + usuario.getEmail() + "',"
				+ "'" +usuario.getClave()+"',"
				+ "'" +usuario.getFecha_de_nacimiento()+"',"
				+ "'" +usuario.getDomicilio().getId()+"')";
		boolean resultado = false;
		try {
			conexion.getStmt().executeUpdate(sql);
			resultado = true;
			System.out.println("Usuario registrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public ArrayList<Usuario> consultarUsuarios(){
		    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			this.sql = "SELECT * FROM usuario";
			try {
				conexion.setRs(conexion.getStmt().executeQuery(sql));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Usuarios Registrados en Supermark:");
				ResultSet rs = conexion.getRs();
				try {
					while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
						CrudDomicilio cdom = new CrudDomicilio();
						Domicilio dom = cdom.getDomicilio(rs.getInt("id_domicilio"));
						if(dom!=null) {
							Usuario user = new Usuario(
									rs.getString("nombre"),
									rs.getString("apellido"),
									rs.getString("email"),
									rs.getString("clave"),
									rs.getDate("fecha_de_nacimiento"),
									dom
									);
							usuarios.add(user);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return usuarios;
		}

	public boolean iniciarSesion (Usuario user){
		        this.sql = "SELECT * FROM usuario WHERE usuario.email = '"+user.getEmail()+"' AND usuario.clave = '"+user.getClave()+"'";
			boolean resultado = false;
			try {
				conexion.setRs(conexion.getStmt().executeQuery(sql));
				while(conexion.getRs().next()){
				  resultado = true;
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	   return resultado;
	}

	
	public ArrayList<Usuario> getCompradores(){
		    ArrayList<Usuario> compradores = new ArrayList<Usuario>();
			this.sql = "SELECT distinct usuario.id, usuario.nombre, usuario.apellido, usuario.email,comprobante.id_usuario FROM comprobante\r\n"
					+ "inner join usuario ON comprobante.id_usuario = usuario.id";
			try {
				conexion.setRs(conexion.getStmt().executeQuery(sql));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Compradores de Supermark:");
				ResultSet rs = conexion.getRs();
				try {
					while (rs.next()) {
						Usuario comprador = new Usuario(
								rs.getInt("id"),
								rs.getString("nombre"),
								rs.getString("apellido"),
								rs.getString("email"));
						compradores.add(comprador);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					}
				}
			return compradores;
			}
	
	public boolean estaRegistrado(Usuario user) {
		this.sql = "SELECT * FROM usuario WHERE usuario.email='"+user.getEmail()+"'";
		boolean resultado = false;
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
			while(conexion.getRs().next()) {
				resultado = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean esAdmin(Usuario usuario) {
		this.sql = "SELECT rol FROM Usuario WHERE id="+usuario.getId_usuario();
		boolean resultado = false;
		try {
			ResultSet rs = conexion.getStmt().executeQuery(sql);
			if(rs.getInt("rol")==1) {//si es admin
				resultado = true;
			}
			System.out.println("Usuario registrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
}