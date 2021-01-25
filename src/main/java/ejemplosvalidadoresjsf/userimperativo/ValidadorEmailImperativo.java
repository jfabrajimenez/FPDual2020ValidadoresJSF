package ejemplosvalidadoresjsf.userimperativo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userImperativo.validadorEmailImperativo")
public class ValidadorEmailImperativo implements Validator {
	private static final String PATRON_EMAIL="^[_A-Za-z0-9-]+(\\."
            + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	private Matcher matcher;
	private String nombre;
	
	public ValidadorEmailImperativo() {
		this.pattern=Pattern.compile(PATRON_EMAIL);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(value == null) {
			return;
		}
		
		if(this.getNombre() == null || this.getNombre().isEmpty()) {
			FacesMessage msgUsuarioNoInformado=new FacesMessage("Error formulario sin nombre", "Error, se ha olvidado de informar el nombre del usuario.");
			msgUsuarioNoInformado.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msgUsuarioNoInformado);
		}
		
		this.matcher=this.pattern.matcher(value.toString());
		if(!this.matcher.matches()) {
			FacesMessage msgEmailIncorrecto=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error email incorrecto", "Error, el email introducido no es un email válido");
			throw new ValidatorException(msgEmailIncorrecto);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
