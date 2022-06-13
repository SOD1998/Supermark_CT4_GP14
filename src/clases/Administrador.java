package clases;

public class Administrador {
	private String Apellido;
	private String Nombre;
	private String Email;
	private String Domicilio;
	private String Telefono;
	private String CUIL;
	
	public Administrador(String Apellido, String Nombre, String Email, String Domicilio, String Telefono, String CUIL) {
		this.Apellido = Apellido;
		this.Nombre = Nombre;
		this.Email = Email;
		this.Domicilio = Domicilio;
		this.Telefono = Telefono;
		this.CUIL = CUIL;
	}
	
	public void setApellido(String Apellido) {
		this.Apellido = Apellido;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public void setDomicilio(String Domicilio) {
		this.Domicilio = Domicilio;
	}
	
	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	
	public void setCUIL(String CUIL) {
		this.CUIL = CUIL;
	}
	
	public void Mostrar() {
		System.out.println("Datos del administrador: ");
		System.out.println("Apellido: "+this.Apellido);
		System.out.println("Nombre: "+this.Nombre);
		System.out.println("Email: "+this.Email);
		System.out.println("Domicilio: "+this.Domicilio);
		System.out.println("Telefono: "+this.Telefono);
		System.out.println("CUIL: "+this.CUIL);
	}

}
