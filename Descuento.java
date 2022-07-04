package Entidades;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;


public class Descuento {
	
	private float puntos;
	private String codDescuento;
	Connection con;
	

	public float getPuntos() {
		return puntos;
	}
	
	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}
	
	public String getCodDescuento() {
		return codDescuento;
	}
	
	public void setCodDescuento(String codDescuento) {
		this.codDescuento = codDescuento;
	}
	
	
	
	   String SQL = "SELECT * FROM descuento where cogdescuento";
	   Statement stmt = con.createStatement();
	   ResultSet rs = stmt.executeQuery(SQL);
	
	   public void calcularDescuento(String codDescuento) {
		try {
			   

			   while (rs.next()) {
			   if(codDescuento == rs) {
				   JOptionPane.showMessageDialog(null,"Descuento aplicado");
			   }
			}
			  
			  rs.close();
			  stmt.close();
			}
			catch (Exception e) {
			  e.printStackTrace();
			}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
