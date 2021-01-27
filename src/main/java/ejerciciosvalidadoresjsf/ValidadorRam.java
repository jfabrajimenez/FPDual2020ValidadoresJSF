package ejerciciosvalidadoresjsf;

import java.util.ArrayList;
import java.util.List;
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
		List<FacesMessage> lErrores = new ArrayList<>();

		lErrores.addAll(this.validar(value));

		if (!lErrores.isEmpty()) {
			throw new ValidatorException(lErrores);
		}
	}

	protected List<FacesMessage> validar(Object value) {
		List<FacesMessage> lErrores = new ArrayList<>();

		if (Objects.nonNull(value) && (Integer) value > 4 && MARCA_IPHONE.equalsIgnoreCase(this.marca)) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cantidad de RAM desproporcionada para Iphone",
					"Un Iphone no puede tener más de 4 GB de memoria RAM"));
		}

		return lErrores;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
