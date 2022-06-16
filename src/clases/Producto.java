package clases;

public class Producto {
	private Integer Id_Producto;
	private String Nombre;
	private Float Precio_unitario;
	private Integer Stock;
	private String Detalle;
	
	public Integer getId_Producto() {
		return Id_Producto;
	}

	public String getNombre() {
		return this.Nombre;
	}
	
	public Float getPrecio_unitario() {
		return this.Precio_unitario;
	}
	
	public Integer getStock() {
		return this.Stock;
	}
	
	public String getDetalle() {
		return this.Detalle;
	}
	
	public void setId_Producto(Integer id_Producto) {
		Id_Producto = id_Producto;
	}
		
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setPrecio_unitario(Float Precio_unitario) {
		this.Precio_unitario = Precio_unitario;
	}
	
	public void setStock(Integer Stock) {
		this.Stock = Stock;
	}
	
	public void setDetalle(String Detalle) {
		this.Detalle = Detalle;
	}
	
	public boolean Comprar_producto (Integer Cantidad_comprada, Producto producto) {
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
