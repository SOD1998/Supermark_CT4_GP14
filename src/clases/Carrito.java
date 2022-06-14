package clases;

public class Carrito {
	private Producto Producto;
	private int Cantidad_de_producto;
	private String Codigo_descuento;
	private String Medio_pago;
	private String Envio;
	
	public Carrito (Producto Producto, int Cantidad_de_producto, String Codigo_descuento, String Medio_pago, String Envio) {
		this.Producto = Producto;
		this.Cantidad_de_producto = Cantidad_de_producto;
		this.Codigo_descuento = Codigo_descuento;
		this.Medio_pago = Medio_pago;
		this.Envio = Envio;
	}
	
	public void setProducto(Producto Producto) {
		this.Producto = Producto;
	}
	
	public void setCantidad_de_producto(int Cantidad_de_producto) {
		this.Cantidad_de_producto = Cantidad_de_producto;
	}
	
	public void setCodigo_descuento(String Codigo_descuento) {
		this.Codigo_descuento = Codigo_descuento;
	}
	
	public void setMedio_pago(String Medio_pago) {
		this.Medio_pago = Medio_pago;
	}
	
	public void setEnvio(String Envio) {
		this.Envio = Envio;
	}
	
	public boolean Quitar_del_carrito(Producto producto, int Cantidad_a_quitar) {
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
	
	public double Costo_acumulado() {
		double Precio_compra = 0;
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
	
	public void Mostrar() {
		System.out.println("Datos del Carrito: ");
		System.out.println("Productos en el carrito: " + Producto.getNombre());
		System.out.println("Cantidad de productos: " + this.Cantidad_de_producto);
		System.out.println("Código de descuento: "+this.Codigo_descuento);
		System.out.println("Medio de pago: "+this.Medio_pago);
		System.out.println("Envío: "+this.Envio);
	}

}
