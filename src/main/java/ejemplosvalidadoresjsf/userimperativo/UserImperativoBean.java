package ejemplosvalidadoresjsf.userimperativo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name="userImperativo")
@RequestScoped
public class UserImperativoBean implements Serializable {
	private static final long serialVersionUID = -7846990650494651172L;

	private String nombre;
	private String email;
	
	public void valorNombreCambiado(AjaxBehaviorEvent evento) {
		System.out.println("Nombre modificado");
	}
	
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
