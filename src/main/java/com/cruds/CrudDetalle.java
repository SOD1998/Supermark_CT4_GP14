package com.cruds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.objetos.Comprobante;
import com.objetos.Conector;
import com.objetos.Detalle;
import com.objetos.Producto;



public class CrudDetalle {
	
	private Conector conexion;
	private String sql;
	
	public CrudDetalle() {
		this.conexion = new Conector();
		this.conexion.connect(); // Abre la conexion
		this.sql = " ";
	     }
		
	public ArrayList<Detalle> getLineasDetalle(Comprobante comp){
		ArrayList<Detalle> detalles = new ArrayList<Detalle>();
		this.sql = "SELECT * FROM Detalle WHERE id_comprobante ="+
				comp.getId();
		ResultSet rs;
		try {
			rs = conexion.getStmt().executeQuery(sql);
			CrudProducto cp = new CrudProducto();
			while (rs.next()) {
				Producto prod = cp.getProducto(rs.getInt("id_producto"));
				Detalle linea = new Detalle(prod, rs.getInt("cantidad"));
				detalles.add(linea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return detalles;
	}
	     
	     public void registrarDetalle(Detalle detalle,Integer id_comprobante) {
	 		this.sql = "INSERT INTO detalle "+
	 				"(id_comprobante,id_producto,cantidad) "+
	 				"VALUE ("+
	 				id_comprobante+","+
	 				detalle.getDescripcion().getId_Producto()+","+
	 				detalle.getCantidad()+")";
	 		try {
	 			conexion.getStmt().executeUpdate(sql);
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 		}finally {
	 			System.out.println("Linea de Detalle agregada");
	 		}
	 	}
	     
}
