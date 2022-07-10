package com.cruds;


import java.sql.*;
import java.util.ArrayList;

import com.objetos.Comprobante;
import com.objetos.Conector;
import com.objetos.Detalle;
import com.objetos.Usuario;



public class CrudComprobante {

	private Conector conexion;
	private String sql;

	public CrudComprobante () {
		this.conexion = new Conector();
		this.conexion.connect(); // Abre la conexion
		this.sql = " ";
	}
	
	public ArrayList<Comprobante> getComprobantes(Usuario usuario){
		    ArrayList<Comprobante> comprobantes = new ArrayList<Comprobante>();
			this.sql = "SELECT * FROM comprobante WHERE id_usuario ="+
				    usuario.getId_usuario();
			try {
				conexion.setRs(conexion.getStmt().executeQuery(sql));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Comprobantes del cliente");
				ResultSet rs = conexion.getRs();
                                try {
                                CrudDetalle cd = new CrudDetalle();
				while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
					Comprobante comp = new Comprobante();
				        comp.setId(rs.getInt("Id"));
				        comp.setTipo(rs.getString("Tipo"));
				        comp.setFecha(rs.getTimestamp("fecha_emision"));
				        comp.setDetalles(cd.getLineasDetalle(comp));//Busco las lineas de detalle asociadas a los productos del comprobante
				        comprobantes.add(comp);
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   return comprobantes;
	}
	
	private void agregarDetallesAComprobante(ArrayList<Detalle> detalles,Integer id_comprobante) {
		CrudDetalle cd = new CrudDetalle();
		CrudProducto cp = new CrudProducto();
		for(Detalle det:detalles) {
			int stockActual = cp.getStockActual(det.getDescripcion());
			det.getDescripcion().setStock(stockActual);
			
			int cantidadProducto = det.getCantidad();
			
			if(stockActual-cantidadProducto>=0) {
				//Insertamos una fila en la tabla Detalle
				cd.registrarDetalle(det,id_comprobante);
				//Actualizacion sobre la tabla Producto
				//cp.getStockActual(det.getProducto());
				cp.actualizarStock(det.getDescripcion(), - cantidadProducto);
			}else {
				System.out.println("No se dispone del stock necesario para realizar esta venta");
			}
		}
	}

	public boolean registrarCompra(Comprobante comprobante) {
		boolean resultado = false;//Si se ejecuta correctamente la consulta SQL
		CrudCarrito ccarr = new CrudCarrito();
		ArrayList<Detalle> detalles = ccarr.getListado(comprobante.getDestinatario());
		comprobante.setDetalles(detalles);
		float total = 0;
		for(Detalle detalle:detalles) {
			total += detalle.getDescripcion().getPrecio_unitario()*detalle.getCantidad();
		}
		// Descuentos aplicados sobre el total de las compras.
		float descuento = 0;
		if (total >= 1000 && total < 5000) {
			descuento = (float) 0.05;
		}
		else if (total >= 5000 && total < 10000) {
			descuento = (float) 0.1;
		}
		else if (total >= 10000) {
			descuento = (float) 0.15;
		}
		else {
			descuento = 0;
		}
		total = total - total*descuento;
		this.sql = "INSERT INTO Comprobante "+
				"(tipo,fecha_emision,id_usuario,id_tarjeta,total) "+
				"VALUE ('"+
				comprobante.getTipo()+"','"+
				comprobante.getFecha()+"',"+
				comprobante.getDestinatario().getId_usuario()+","+
				comprobante.getTarjeta().getNumero()+","+
				total+")";
		try {
			PreparedStatement stmt = conexion.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int filas = stmt.executeUpdate();
			if(filas>0) {
				resultado = true;
				ResultSet rs = stmt.getGeneratedKeys();
				while(rs.next()) {//Asignamos al comprobante el id generado en MySQL
					comprobante.setId(rs.getInt(1));
				}
			}
			agregarDetallesAComprobante(detalles,comprobante.getId());
			ccarr.vaciar(comprobante.getDestinatario());
			System.out.println("Comprobante registrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
}
