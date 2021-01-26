package ejerciciosvalidadoresjsf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ejercicio1.validadorSistemasOperativosPermitidos")
public class ValidadorSistemasOperativosPermitidos extends ValidadorTextosPermitidos {
	private static final String MARCA_IPHONE ="iphone";
	private static final String SO_IPHONE="ios";
	
	private String marca;
	
	public ValidadorSistemasOperativosPermitidos() {
		super();

		this.setTextosPermitidos(Arrays.asList("Android", "IOS"));
	}

	@Override
	protected String getErrorCorto() {
		return "El sistema operativo indicado no está en el catálogo.";
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		List<FacesMessage> lErrores=new ArrayList<>();
		
		lErrores.addAll(this.validar(value));
		lErrores.addAll(this.validarCompatibilidadConMarca(value));
		
		if(!lErrores.isEmpty()) {
			throw new ValidatorException(lErrores);
		}
	}
	
	private List<FacesMessage>validarCompatibilidadConMarca(Object value){
		List<FacesMessage> lErrores=new ArrayList<>();
		
		if(SO_IPHONE.equalsIgnoreCase(value.toString()) && !MARCA_IPHONE.equalsIgnoreCase(this.marca)) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "La marca no es compatible con el sistema operativo indicado", "Para los móviles Iphone solo se puede indicar el sistema operativo IOS"));
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
