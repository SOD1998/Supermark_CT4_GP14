package com.cruds;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.objetos.Conector;
import com.objetos.Producto;



public class CrudProducto {

	private Conector conexion;
	private String sql;

	public CrudProducto () {
		super();
		this.conexion = new Conector();
		this.conexion.connect(); // Abre la conexion
		this.sql = " ";
	}

	public Producto getProducto(Integer id){
	     Producto prod = null;
	     this.sql = "SELECT * FROM producto WHERE id="+id;
	     try {
	         ResultSet rs = conexion.getStmt().executeQuery(sql);
	         while (rs.next()) {
	            prod = new Producto(
	                     rs.getString("nombre"),
	                     rs.getString("marca"),
	                     rs.getDate("vencimiento"),
	                     rs.getFloat("precio"),
	                     rs.getInt("stock"));
	     }
	} catch(SQLException e) {
	    e.printStackTrace();
	}
	return prod;
 }

	public int getStockActual(Producto producto) {
		int stockActual = 0;
		this.sql = "SELECT stock FROM Producto WHERE id="+producto.getId_Producto();
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
			int count = 0;
			while(conexion.getRs().next()) {
				stockActual = conexion.getRs().getInt("stock");
			}
			if(count>0) {
				System.out.println("Stock Actualizado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockActual;
	}
	
	public boolean insertar (Producto producto) { // Insertar producto
		boolean resultado = false;
		this.sql = "INSERT INTO producto \r\n"
	            + "(nombre, marca, vencimiento, stock, precio) \r\n"
				+ "VALUES"
				+ "('" + producto.getNombre() + "',"
	            + "'" + producto.getMarca()+"',"
	            + "'" + producto.getVencimiento()+"',"
	            + "'" + producto.getStock()+"',"
	            + "'" + producto.getPrecio_unitario()+"')";
		try {
			conexion.getStmt().executeUpdate(this.sql);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Producto agregado exitosamente");
		}
		return resultado;
		
	}
	
	public ArrayList<Producto> consultarProductosDisponibles(){
	    ArrayList<Producto> productos = new ArrayList<Producto>();
		this.sql = "SELECT * FROM producto WHERE stock>"+0;
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Nomina de productos disponibles en Supermark:");
			ResultSet rs = conexion.getRs();
			try {
				while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
					Producto prod = new Producto(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("marca"),
							rs.getDate("vencimiento"),
							rs.getInt("stock"),
							rs.getFloat("precio"));
					productos.add(prod);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	}
   return productos;	
}
	
	public ArrayList<Producto> consultarProductosSinStock(){
	    ArrayList<Producto> productos = new ArrayList<Producto>();
		this.sql = "SELECT * FROM producto WHERE stock="+0;
		try {
			conexion.setRs(conexion.getStmt().executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Nomina de productos sin stock en Supermark:");
			ResultSet rs = conexion.getRs();
			try {
				while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
					Producto prod = new Producto(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("marca"),
							rs.getDate("vencimiento"),
							rs.getInt("stock"),
							rs.getFloat("precio"));
					productos.add(prod);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	}
   return productos;	
}
	
	public boolean actualizarStock(Producto producto,Integer cantidad) {
		boolean resultado = false;
		this.sql = "UPDATE producto SET producto.stock="+
				(producto.getStock()+cantidad)+
				" WHERE producto.id="+producto.getId_Producto();
		try {
			conexion.getStmt().executeUpdate(sql);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Stock Actualizado");
		}
		return resultado;
	}
	
	public boolean actualizarPrecio(Producto producto,Float precio) {
		boolean resultado = false;
		this.sql = "UPDATE producto SET producto.precio="+precio+
				" WHERE producto.id="+producto.getId_Producto();
		try {
			conexion.getStmt().executeUpdate(sql);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Precio Actualizado");
		}
		return resultado;
	}
	
	public boolean eliminarProducto(Producto producto){
		boolean resultado = false;
		this.sql = "DELETE FROM producto WHERE id = "+ producto.getId_Producto();
		
		try {
			conexion.getStmt().executeUpdate(sql);
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Producto eliminado");
		}
		return resultado;
	}
	
}
