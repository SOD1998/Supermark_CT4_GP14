package clases;

public class Usuario {
	private String Nombre_de_usuario;
	private String Email;
	private String Clave;
	private String Tipo;
	
	public Usuario(String Nombre_de_usuario, String Email, String Clave, String Tipo) {
		this.Nombre_de_usuario = Nombre_de_usuario;
		this.Email = Email;
		this.Clave = Clave;
		this.Tipo = Tipo;
	}
	
	public void setNombre_de_usuario(String Nombre_de_usuario) {
		this.Nombre_de_usuario = Nombre_de_usuario;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public void setClave(String Clave) {
		this.Clave = Clave;
	}
	
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	
	public void Mostrar() {
		System.out.println("Datos del usuario: ");
		System.out.println("Nombre de usuario: "+this.Nombre_de_usuario);
		System.out.println("Email: "+this.Email);
		System.out.println("Clave: "+this.Clave);
		System.out.println("Telefono: "+this.Tipo);
	}

}
