package clases;

public class Carrito {
	private Producto Producto;
	private Integer Cantidad_de_producto;
	
	public void setProducto(Producto Producto) {
		this.Producto = Producto;
	}
	
	public void setCantidad_de_producto(Integer Cantidad_de_producto) {
		this.Cantidad_de_producto = Cantidad_de_producto;
	}
	
	public Producto getProducto() {
		return Producto;
	}

	public Integer getCantidad_de_producto() {
		return Cantidad_de_producto;
	}

	public boolean Quitar_del_carrito(Producto producto, Integer Cantidad_a_quitar) {
		if (Cantidad_a_quitar <= 0 || Cantidad_a_quitar > this.Cantidad_de_producto) {
			System.out.println("No es posible quitar esa cantidad de productos");
			return false;
		}
		else {
			this.Cantidad_de_producto = this.Cantidad_de_producto - Cantidad_a_quitar;
			System.out.println("Se quitaron exitosamente del carrito " + Cantidad_a_quitar +" de " + Producto.getNombre());
			return true;
		}
	}
	
	public float Costo_acumulado() {
		float Precio_compra = 0;
		if (this.Cantidad_de_producto == 0) {
			System.out.println("Total a pagar: $" + Precio_compra);
			return Precio_compra;
		}
		else {
			Precio_compra = this.Cantidad_de_producto*Producto.getPrecio_unitario();
			System.out.println("Total a pagar: $" + Precio_compra);
			return Precio_compra;
		}
	}
	
	public boolean Comprar_producto (Integer Cantidad_comprada, Producto producto) {
		if (Cantidad_comprada > producto.getStock() || Cantidad_comprada <= 0) {
			System.out.println("No es posible realizar la compra");
			return false;
		}
		else {
			producto.Comprar_producto(Cantidad_comprada, producto);
			return true;
		}
	}
}
