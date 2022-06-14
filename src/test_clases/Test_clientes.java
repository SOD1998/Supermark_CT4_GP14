package test_clases;

import clases.Cliente;
import clases.Producto;
import clases.Tarjeta_super;
import clases.Usuario;
import clases.Administrador;
import clases.Carrito;

public class Test_clientes {

	public static void main(String[] args) {
		
		/*
		Cliente cliente_1 = new Cliente("Dahan", "Selim Omar", "selimomardahan@gmail.com", "Tartagal", "1234", "4321");
		cliente_1.Mostrar();
		
		Administrador admin_1 = new Administrador("Molina", "Milagro", "milagrorosariomolina@hotmail.com", "Tartagal", "2345", "5432");
		admin_1.Mostrar();
		
		Usuario usuario_1 = new Usuario("selim0dahan", "selimomardahan@gmail.com", "1234", "Cliente");
		Usuario usuario_2 = new Usuario("milagr0molina", "milagrorosariomolina@hotmail.com", "2345", "Administrador");
		usuario_1.Mostrar();
		usuario_2.Mostrar();
		
		Producto prod_1 = new Producto(1, "Arroz", 100, 500, "Alimento");
		prod_1.getNombre();
		prod_1.Mostrar();
		prod_1.Agregar_al_carrito(10, prod_1);
		prod_1.Comprar_producto(10, prod_1);
		prod_1.Mostrar();
		
		Carrito carrito_1 = new Carrito(prod_1, 10, "D35CU3N70", "Débito", "A domicilio");
		carrito_1.Mostrar();
		carrito_1.Costo_acumulado();
		carrito_1.Quitar_del_carrito(prod_1, 6);
		carrito_1.Mostrar();
		carrito_1.Costo_acumulado();
		*/
		Tarjeta_super tarj_sup_1 = new Tarjeta_super(1, 123.45);
		tarj_sup_1.Mostrar();
		tarj_sup_1.Canjear_puntos(10);
		tarj_sup_1.Mostrar();

	}

}
