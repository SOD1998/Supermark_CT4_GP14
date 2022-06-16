package clases;

public class Cliente {
	private Integer Id_cliente;
	private String Apellido;
	private String Nombre;
	private String DNI;
	private String Email;
	private Domicilio Domicilio;
	private String Telefono;
	private Tarjeta Tarjeta;
	private Carrito Carrito;
	
	public String getDNI() {
		return DNI;
	}

	public Integer getId_cliente() {
		return Id_cliente;
	}

	public String getApellido() {
		return Apellido;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getEmail() {
		return Email;
	}

	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public String getTelefono() {
		return Telefono;
	}

	public Tarjeta getTarjeta() {
		return Tarjeta;
	}
	
	public Carrito getCarrito() {
		return Carrito;
	}
	
	public void setId_cliente(Integer id_cliente) {
		this.Id_cliente = id_cliente;
	}

	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setDNI(String dNI) {
		this.DNI = dNI;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public void setDomicilio(Domicilio Domicilio) {
		this.Domicilio = Domicilio;
	}
	
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	
	public void setTarjeta(Tarjeta Tarjeta) {
		this.Tarjeta = Tarjeta;
	}

	public void setCarrito(Carrito carrito) {
		this.Carrito = carrito;
	}

	public boolean Agregar_al_carrito (Integer Cantidad_agregada, Producto producto) {
		if (Cantidad_agregada <= 0  || producto.getStock() < Cantidad_agregada) {
			System.out.println("No es posible agregar esa cantidad de " + producto.getNombre() + " al carrito");
			return false;
		}
		else {
			System.out.println("Se agregaron " + Cantidad_agregada + " de " + producto.getNombre() + " al carrito");
			return true;
		}
	}
	
	public boolean Pagar_carrito (Carrito Carrito, Tarjeta Tarjeta) {
		if (Tarjeta.getSaldo() > Carrito.Costo_acumulado() && Carrito.Costo_acumulado() > 0 && Carrito.Comprar_producto(Carrito.getCantidad_de_producto(),  Carrito.getProducto()) == true) {
			Tarjeta.setSaldo(Tarjeta.getSaldo() - Carrito.Costo_acumulado());
			Carrito.Comprar_producto(Carrito.getCantidad_de_producto(), Carrito.getProducto());
			System.out.println("Compra realizada exitosamente. Su saldo actual es: $" + Tarjeta.getSaldo());
			return true;
		}
		else {
			System.out.println("No es posible realizar la compra");
			return false;
		}
	}
}
