package clases;

public class Usuario {
	private Integer Id_usuario;
	private String Nombre_de_usuario;
	private String Email;
	private String Clave;
	private Character Tipo;
	
	public Usuario(Integer Id_usuario, String Nombre_de_usuario, String Email, String Clave, Character Tipo) {
		this.Id_usuario = Id_usuario;
		this.Nombre_de_usuario = Nombre_de_usuario;
		this.Email = Email;
		this.Clave = Clave;
		this.Tipo = Tipo;
	}
	
	public Integer getId_usuario() {
		return Id_usuario;
	}

	public String getNombre_de_usuario() {
		return Nombre_de_usuario;
	}

	public String getEmail() {
		return Email;
	}

	public String getClave() {
		return Clave;
	}

	public Character getTipo() {
		return Tipo;
	}
	
	public void setId_usuario(Integer id_usuario) {
		Id_usuario = id_usuario;
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
	
	public void setTipo(Character Tipo) {
		this.Tipo = Tipo;
	}
	
	public void Mostrar() {
		System.out.println("Datos del usuario: ");
		System.out.println("Nombre de usuario: "+this.Nombre_de_usuario);
		System.out.println("Email: "+this.Email);
		System.out.println("Clave: "+this.Clave);
		System.out.println("Tipo: "+this.Tipo);
	}
	
	
	
}
