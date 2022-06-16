package test_clases;

import clases.Cliente;
import clases.Domicilio;
import clases.Producto;
import clases.Tarjeta;
import clases.Premios;
import clases.Usuario;
import clases.Administrador;
import clases.Carrito;

public class Test_clientes {

	public static void main(String[] args) {
		Producto prod = new Producto();
		prod.setNombre("Arroz");
		prod.setPrecio_unitario((float) 50.50);
		prod.setStock(8);
		
		//prod.Comprar_producto(12, prod);
		Cliente cliente = new Cliente();
		//cliente.Agregar_al_carrito(5, prod);
		
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setSaldo((float) 1200.45);
		
		Carrito carrito = new Carrito();
		carrito.setProducto(prod);
		carrito.setCantidad_de_producto(8);
		
		cliente.Pagar_carrito(carrito, tarjeta);
		

	}

}
