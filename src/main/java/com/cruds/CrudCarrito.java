package com.cruds;

import java.util.ArrayList;
import java.sql.*;

import com.objetos.Carrito;
import com.objetos.Conector;
import com.objetos.Detalle;
import com.objetos.Producto;
import com.objetos.Usuario;

public class CrudCarrito {
	
	private Conector conexion;
	private String sql;

	public CrudCarrito () {
		this.conexion = new Conector();
		this.conexion.connect(); // Abre la conexion
		this.sql = " ";
	}
	
	public ArrayList<Detalle> getListado(Usuario usuario){
		ArrayList<Detalle> detalles = new ArrayList<Detalle>();
		
		this.sql = "SELECT Producto.nombre,Carrito.id_producto,Carrito.cantidad,Producto.precio FROM Carrito "+
					"JOIN producto ON producto.id = carrito.id_producto "+
					"WHERE id_usuario = "+usuario.getId_usuario();
		
		try {
			ResultSet rs = conexion.getStmt().executeQuery(sql);
			while(rs.next()) {
				int id_producto = rs.getInt("id_producto");
				int cantidad = rs.getInt("cantidad");
				String nombre = rs.getString("nombre");
				float precio = rs.getFloat("precio");
				detalles.add(new Detalle(new Producto(id_producto,nombre,precio),cantidad));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return detalles;
	}
	
	public boolean agregar(Carrito carrito) {//-->Registrar un producto en el carrito
		boolean resultado = false;
		if(getListado(carrito.getUsuario()).size()<=30) {
			this.sql = "INSERT INTO Carrito "+
					"(id_usuario,id_producto,cantidad) "+
					"VALUE ("+
					carrito.getUsuario().getId_usuario()+","+
					carrito.getProducto().getId_Producto()+","+
					carrito.getCantidad()+")";
			try {
				int filas = conexion.getStmt().executeUpdate(sql);
				if(filas>0){
					resultado = true;
				}
				System.out.println("Producto agregado al Carrito");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("El carrito esta lleno");
		}
		
		return resultado;
	}
	
	public boolean vaciar(Usuario usuario){
		boolean resultado = false;
		this.sql = "DELETE FROM Carrito WHERE id_usuario = "+usuario.getId_usuario();
		
		try {
			int filas = conexion.getStmt().executeUpdate(sql);
			if(filas>0) {
				resultado = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
}