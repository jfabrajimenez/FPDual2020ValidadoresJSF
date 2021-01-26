package ejerciciosvalidadoresjsf;

import java.util.Arrays;

import javax.faces.validator.FacesValidator;

@FacesValidator("ejercicio1.validadorColoresPermitidos")
public class ValidadorColoresMovilPermitidos extends ValidadorTextosPermitidos {

	public ValidadorColoresMovilPermitidos() {
		super();

		this.setTextosPermitidos(Arrays.asList("Rojo", "Plata", "Blanco", "Azul"));
	}

	@Override
	protected String getErrorCorto() {
		return "El color indicado no está en el catálogo.";
	}

}
