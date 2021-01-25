package ejemplosvalidadoresjsf.userbackingbean;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import ejemplosvalidadoresjsf.userimperativo.ValidadorEmailImperativo;

@ManagedBean(name = "userBacking")
@SessionScoped
public class UserBackingBean implements Serializable {
	private static final long serialVersionUID = 5195960947293783128L;

	private String nombre;
	private String email;

	public void validateEmail(FacesContext contexto, UIComponent componente, Object valor) {
		if (valor == null) {
			return;
		}

		String patronEmail = "^[_A-Za-z0-9-]+(\\." + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
				+ "(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(patronEmail);
		Matcher matcher = pattern.matcher(valor.toString());
		if (!matcher.matches()) {
			FacesMessage msgEmailIncorrecto = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error email incorrecto",
					"Error, el email introducido no es un email válido");
			throw new ValidatorException(msgEmailIncorrecto);
		}
	}
	
	public void validarEmailAprovechandoValidadorDeEmail(FacesContext contexto, UIComponent componente, Object valor) {
		ValidadorEmailImperativo validador=new ValidadorEmailImperativo();
		validador.setNombre("Federico");
		validador.validate(contexto, componente, valor);
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
