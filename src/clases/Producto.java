package clases;

public class Producto {
	private int Id_Producto;
	private String Nombre;
	private double Precio_unitario;
	private int Stock;
	private String Detalle;
	
	public Producto (int Id_Producto, String Nombre, double Precio_unitario, int Stock, String Detalle) {
		this.Id_Producto = Id_Producto;
		this.Nombre = Nombre;
		this.Precio_unitario = Precio_unitario;
		this.Stock = Stock;
		this.Detalle = Detalle;
	}
	
	public int getId_Producto() {
		return Id_Producto;
	}

	public String getNombre() {
		return this.Nombre;
	}
	
	public double getPrecio_unitario() {
		return this.Precio_unitario;
	}
	
	public int getStock() {
		return this.Stock;
	}
	
	public String getDetalle() {
		return this.Detalle;
	}
	
	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}
		
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setPrecio_unitario(double Precio_unitario) {
		this.Precio_unitario = Precio_unitario;
	}
	
	public void setStock(int Stock) {
		this.Stock = Stock;
	}
	
	public void setDetalle(String Detalle) {
		this.Detalle = Detalle;
	}
		
	public void Mostrar() {
		System.out.println("Datos del producto: ");
		System.out.println("Nombre: "+this.Nombre);
		System.out.println("Precio unitario: $"+this.Precio_unitario);
		System.out.println("Stock: "+this.Stock);
		System.out.println("Detalle: "+this.Detalle);
	}
	
	public boolean Agregar_al_carrito (int Cantidad_agregada, Producto producto) {
		if (Cantidad_agregada <= 0  || producto.Stock < Cantidad_agregada) {
			System.out.println("No es posible agregar esa cantidad de " + producto.Nombre + " al carrito");
			return false;
		}
		else {
			System.out.println("Se agregaron " + Cantidad_agregada + " de " + producto.Nombre + " al carrito");
			return true;
		}
		
	}
	
	public boolean Comprar_producto (int Cantidad_comprada, Producto producto) {
		if (Cantidad_comprada > producto.Stock || Cantidad_comprada <= 0) {
			System.out.println("No es posible realizar la compra");
			return false;
		}
		else {
			producto.Stock = producto.Stock - Cantidad_comprada;
			System.out.println("Cantidad del producto restante: " + producto.Stock);
			return true;
		}
	}

}
