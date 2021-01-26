package ejerciciosvalidadoresjsf;

import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ejercicio1.validadorRam")
public class ValidadorRam implements Validator {
	private static final String MARCA_IPHONE = "iphone";

	private String marca;

	public ValidadorRam() {
		super();
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (Objects.nonNull(value) && (Integer) value > 4 && MARCA_IPHONE.equalsIgnoreCase(this.marca)) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cantidad de RAM desproporcionada para Iphone",
							"Un Iphone no puede tener más de 4 GB de memoria RAM"));
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
