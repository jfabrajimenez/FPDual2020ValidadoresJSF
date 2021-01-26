package ejerciciosvalidadoresjsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ejercicio1.validadorTextosPermitidos")
public class ValidadorTextosPermitidos implements Validator {

	private List<String> textosPermitidos;

	public ValidadorTextosPermitidos() {
		super();
	}

	protected Severity getCategoriaError() {
		return FacesMessage.SEVERITY_ERROR;
	}

	protected String getErrorCorto() {
		return "Valor no permitido";
	}

	protected String getErrorLargo() {
		return this.getErrorCorto().concat(" Indique uno de los siguientes: ").concat(this.getTextosPermitidos().stream().collect(Collectors.joining(", ")));
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		List<FacesMessage> lErrores=this.validar(value);
		
		if(!lErrores.isEmpty()) {
			throw new ValidatorException(lErrores);
		}
	}
	
	protected List<FacesMessage>validar( Object value){
		List<FacesMessage> lErrores=new ArrayList<>();
		
		if (Objects.nonNull(value) && !value.toString().isEmpty()) {
			if (!this.esTextoPermitido(value.toString())) {
				FacesMessage msgTextoNoPermitido = new FacesMessage(this.getCategoriaError(), this.getErrorCorto(),
						this.getErrorLargo());
				lErrores.add(msgTextoNoPermitido);
			}
		}
		
		return lErrores;
	}

	private boolean esTextoPermitido(String texto) {
		if (Objects.isNull(texto) || texto.isEmpty() || Objects.isNull(textosPermitidos) || textosPermitidos.isEmpty()) {
			return false;
		}
		
		return this.textosPermitidos.contains(texto.toLowerCase());
	}

	public List<String> getTextosPermitidos() {
		return textosPermitidos;
	}

	public void setTextosPermitidos(List<String> textosPermitidos) {
		if (Objects.nonNull(textosPermitidos) && !textosPermitidos.isEmpty()) {
			this.textosPermitidos = textosPermitidos.stream().map(String::toLowerCase).collect(Collectors.toList());
		} else {
			this.textosPermitidos = textosPermitidos;
		}
	}

}
