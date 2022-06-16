package clases;

public class Premios {
	private Float Puntos;
	private String Cod_descuento;

	public double getPuntos() {
		return Puntos;
	}

	public void setPuntos(Float puntos) {
		Puntos = puntos;
	}
	
	public String getCod_descuento() {
		return Cod_descuento;
	}

	public void setCod_descuento(String cod_descuento) {
		Cod_descuento = cod_descuento;
	}
	
	public boolean Canjear_puntos (float Cantidad_a_canjear, String Cod_descuento) {
		if (Cantidad_a_canjear > this.Puntos || Cantidad_a_canjear <= 0) {
			System.out.println("No es posible canjear los puntos");
			return false;
		}
		else {
			if (Cod_descuento != this.Cod_descuento) {
				System.out.println("Código incorrecto");
				return false;
			}
			else {
				this.Puntos = this.Puntos - Cantidad_a_canjear;
				System.out.println("Cantidad del producto restante: " + this.Puntos);
				return true;
			}
		}
	}
}
