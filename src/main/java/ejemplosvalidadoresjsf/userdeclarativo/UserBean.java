package ejemplosvalidadoresjsf.userdeclarativo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = -6210747437570920941L;
	
//	private Usuario usu;
//	
//	public UserBean() {
//		this.usu=new Usuario();
//	}
//
//	public Usuario getUsu() {
//		return usu;
//	}
//
//	public void setUsu(Usuario usu) {
//		this.usu = usu;
//	}
	
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
