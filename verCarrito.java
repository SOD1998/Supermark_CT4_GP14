package com.supermark;

import static spark.Spark.*;

import java.util.ArrayList;

import com.google.gson.Gson;





public class verCarrito {

	public static void main(String[] args) {
		port(4567);
	
			
		post("/seleccionar",(request,response)->{
			response.type(application/json);
			Gson mapper = new Gson();
			Carrito productoAgregado = mapper.fromJson(request.body(),Carrito.class);
			
			CRUDCarrito ccarr = new CRUDCarrito();
			
			if(ccarr.agregar(productoAgregado)) {
				return mapper.toJson(new StandardResponse(StatusResponse.SUCCESS, "Producto agregado al carrito"));
			}else { 
				return mapper.toJson(new StandardResponse(StatusResponse.ERROR, "Error al agregar producto"));
			}
			
			
			
		});
		
		get("/carrito/:id",(request,response)->{
									
			Gson mapper = new Gson();
			
			CRUDCarrito ccarr = new CRUDCarrito();
			
			ArrayList <Detalle> miCarrito = ccarr.getListado(new Usuario(Integer.valueOf(request.params(":id"))));
			
			if (miCarrito != null && miCarrito.size() > 0){
				return mapper.toJson(new StandardResponse(StatusResponse.SUCCESS,mapper.toJson(miCarrito)));
			}else{
				return mapper.toJson(new StandardResponse(StatusResponse.ERROR,"carrito vacio"));
			}
		});
		
		
		
		
		
		
		
		
		
		
		

	}

}
