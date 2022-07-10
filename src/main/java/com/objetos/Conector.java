package com.objetos;

import java.sql.*;

public class Conector {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/supermark"; //VERIFICAR NOMBRE DE LA BASE DE DATOS
	//Credenciales de la BDD
	static final String USER = "root"; //CAMBIAR
	static final String PASS = "Password"; //CAMBIAR

	Connection conn = null;
	Statement stmt = null;//Objeto para realizar las declaraciones SQL que requiramos
	ResultSet rs = null;//Conjunto de resultados
	
	public Conector() {
		//this.DB_URL += "Supermark";
	}
	
	public void connect () {
			try {
				Class.forName(JDBC_DRIVER); //Instanciar el driver
				
				System.out.println("Conectando a la base datos...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);//Me conecto a la base datos
				
				System.out.println("Creando sentencias SQL...");
				stmt = conn.createStatement();//Especificamos que crearemos una sentencia SQL sobre la conexion previamente creada
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	
	public void close () {
		try {
			rs.close();
			stmt.close();
			conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
				}
		}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
}
