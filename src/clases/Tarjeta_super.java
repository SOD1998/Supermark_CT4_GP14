package clases;

public class Tarjeta_super {
	private int Id_Tarjeta_super;
	private double Puntos;
	
	public Tarjeta_super (int Id_Tarjeta_super, double Puntos) {
		this.Id_Tarjeta_super = Id_Tarjeta_super;
		this.Puntos = Puntos;
	}

	public int getId_Tarjeta_super() {
		return Id_Tarjeta_super;
	}

	public void setId_Tarjeta_super(int id_Tarjeta_super) {
		Id_Tarjeta_super = id_Tarjeta_super;
	}

	public double getPuntos() {
		return Puntos;
	}

	public void setPuntos(float puntos) {
		Puntos = puntos;
	}
	
	public void Mostrar() {
		System.out.println("Datos de la tarjeta super: ");
		System.out.println("Puntos acumulados: "+this.Puntos);
	}
	
	public boolean Canjear_puntos (double Cantidad_a_canjear) {
		if (Cantidad_a_canjear > this.Puntos || Cantidad_a_canjear <= 0) {
			System.out.println("No es posible canjear los puntos");
			return false;
		}
		else {
			this.Puntos = this.Puntos - Cantidad_a_canjear;
			System.out.println("Cantidad del producto restante: " + this.Puntos);
			return true;
		}
	}

}
