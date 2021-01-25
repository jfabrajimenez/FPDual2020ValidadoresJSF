package ejemplosvalidadoresjsf.usuario;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuario")
public class UsuarioManagedBean implements Serializable {
	private static final long serialVersionUID = -8270906684142435629L;

	private String nombre;
	private Date fechaNacimiento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
