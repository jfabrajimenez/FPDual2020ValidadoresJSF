package ejemplosvalidadoresjsf.userdeclarativo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Usuario {

	@NotNull
	@Size(min = 3, message = "El nombre debe tener una longitud mínima de 3 caracteres")
	private String nombre;
	
	private String email;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
