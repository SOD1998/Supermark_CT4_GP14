package com.supermark_g14_ct4;

import static spark.Spark.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cruds.CrudCarrito;
import com.cruds.CrudComprobante;
import com.cruds.CrudDomicilio;
import com.cruds.CrudProducto;
import com.cruds.CrudUsuario;
import com.google.gson.Gson;
import com.objetos.Carrito;
import com.objetos.Comprobante;
import com.objetos.Detalle;
import com.objetos.Domicilio;
import com.objetos.Producto;
import com.objetos.Usuario;

public class App {

	public static void main(String[] args) {
		
		port(8080);
		Gson transform = new Gson();
		
/*

// Para el cliente: Registrarse

		post("/registrarse",(request,response)->{
			
			Usuario user = transform.fromJson(request.body(), Usuario.class);
			
			CrudUsuario cu = new CrudUsuario();
			boolean resultado = cu.registrar(user);
			
			if (resultado == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR));
			}
		});
		
*/
/*

// Para el cliente: Iniciar sesión

		post("/login",(request,response)->{
			
			Usuario user = transform.fromJson(request.body(), Usuario.class);
			
			CrudUsuario cu = new CrudUsuario();
			boolean resultado = cu.iniciarSesion(user);
			
			if (resultado == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS,"Bienvenido"));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR,"Usuario/clave incorrecta"));
			}
		});

*/
/*

// Para el cliente: Seleccionar hasta 30 productos y agregarlos al carrito
 
		post("/SeleccionarProductos",(req,res)-> {
			
			Carrito productoAgregado = transform.fromJson(req.body(),Carrito.class);

			CrudCarrito changuito = new CrudCarrito();
			if (changuito.agregar(productoAgregado)) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS, "Producto agregado al carrito"));
			}else {
				return  transform.toJson(new StandardResponse(StatusResponse.ERROR, "Producto no agregado / Carrito lleno"));
			}
			});
		
*/
/*

// Para el cliente: Ver listado de productos seleccionados

		get("/ListadoDeProductosSeleccionados/:id",(req,res)-> {
			
			CrudCarrito changuito = new CrudCarrito();
			ArrayList<Detalle> miCarrito = changuito.getListado(new Usuario(Integer.valueOf(req.params(":id"))));
			
			if(miCarrito != null && miCarrito.size()>0) {
			    return transform.toJson(new StandardResponse (StatusResponse.SUCCESS,transform.toJson(miCarrito)));
			}else {
			    return transform.toJson(new StandardResponse(StatusResponse.ERROR,"Tu carrito se encuentra vacio"));
			}
			});

*/
		
// Para el cliente: Autorizar compra de productos selecionados

		
/*
		post("/AutorizarCompra",(request,response)->{
			
			Comprobante comp = transform.fromJson(request.body(), Comprobante.class);
			comp.setFecha(new Timestamp(System.currentTimeMillis()));
			CrudComprobante cc = new CrudComprobante();
			
			boolean resultado = cc.registrarCompra(comp);
			
			if (resultado == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS,"Compra autorizada"));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR,"Error al autorizar compra"));
			}
		});
*/
/*

// Para la Administración: Cargar productos a la aplicación

		post("/CargarProducto",(request,response)->{
			
			Producto prod = transform.fromJson(request.body(), Producto.class);
			
			CrudProducto cp = new CrudProducto();
			boolean resultado = cp.insertar(prod);
			
			if (resultado == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR));
			}
		});

*/
/*

// Para la Administración: Modificar datos de productos cargados:
// Cambiar Stock

		patch("/ModificarStock/:id",(req,res)->{
			
			Producto prod = transform.fromJson(req.body(),Producto.class);
			
			
			CrudProducto cp = new CrudProducto();
			
			Producto prod1 = new Producto(Integer.valueOf(req.params(":id")));
			prod1.setStock(cp.getStockActual(prod1));
			
			boolean res_stock = cp.actualizarStock(prod1, prod.getStock());
			
			
			if (res_stock == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS, transform.toJson(cp.getProducto(Integer.valueOf(req.params(":id"))))));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR));
			}
		});

*/
/*

// Cambiar precio unitario
		
		patch("/ModificarPrecio/:id",(req,res)->{
			
			Producto prod = transform.fromJson(req.body(),Producto.class);
			
			CrudProducto cp = new CrudProducto();
			boolean res_stock = cp.actualizarPrecio(new Producto(Integer.valueOf(req.params(":id"))), prod.getPrecio_unitario());
			
			
			if (res_stock == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS, transform.toJson(cp.getProducto(Integer.valueOf(req.params(":id"))))));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR));
			}
		});

*/
/*

// Para la Administración: Ver todos los usuarios que realizaron una compra.
		
		CrudUsuario cu = new CrudUsuario();
		get ("/Compradores",(request,response)->cu.getCompradores(),transform::toJson);

*/
/*

// Para la Administración: Listado de productos seleccionados por usuario
	
		CrudComprobante ccomp = new CrudComprobante();
		get("/PorductosPorUsuario/:id",(req,res)-> {
					
			ArrayList<Comprobante> comprobantes = ccomp.getComprobantes(new Usuario(Integer.valueOf(req.params(":id"))));
					
			return transform.toJson(comprobantes);
					
			});

*/
/*
// Adicionales implementados:
// Para clientes: Ver listado de productos disponibles:
		
		CrudProducto cp = new CrudProducto();
		get("/ProductosDisponibles",(req,res) -> cp.consultarProductosDisponibles(),transform::toJson);

*/
/*
// Para la Administración: Ver listado de productos sin Stock:
		
		CrudProducto cp = new CrudProducto();
		get("/ProductosSinStock",(req,res) -> cp.consultarProductosSinStock(),transform::toJson);
*/		
/*

		
		
		CrudDomicilio cd = new CrudDomicilio();
		get("/mostrarlista",(req,res) -> cd.consultarDomicilios(),transform::toJson);
	// FC
*/	 
/*		
		
		
		
		post("/registrado",(req, res) -> {
			
			Usuario user = transform.fromJson(req.body(), Usuario.class);
			
			CrudUsuario cu = new CrudUsuario();
			boolean resultado = cu.estaRegistrado(user);
			
			if (resultado == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS,"Registrado"));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR,"No registrado - Usuario incorrecto"));
			}
		});
	// FC
*/		
/*		
		get("/domicilio/:id",(req,res) -> {
			
			
			CrudDomicilio cd = new CrudDomicilio();
			return transform.toJson(cd.getDomicilio(Integer.valueOf(req.params(":id"))));
		});
		
	// FC
*/		
/*		
		CrudUsuario cu = new CrudUsuario();
		get ("/usuarios",(request,response)->cu.consultarUsuarios(),transform::toJson);
		
	// FC
*/		
/*		
		get ("/producto/:id",(req,res)-> {
		
		
		CrudProducto cp = new CrudProducto();
		return transform.toJson(cp.getProducto(Integer.valueOf(req.params(":id"))));
		});
	// FC
*/		
/*		
		delete("/eliminar/:id",(req,res)->{
			
			CrudProducto cp = new CrudProducto();
			boolean resultado = cp.eliminarProducto(new Producto(Integer.valueOf(req.params(":id"))));
			
			if (resultado == true) {
				return transform.toJson(new StandardResponse(StatusResponse.SUCCESS,"Producto eliminado"));
			}
			else {
				return transform.toJson(new StandardResponse(StatusResponse.ERROR,"Error - No es posible eliminar el producto"));
			}
		});
	// FC
*/

	}

}
