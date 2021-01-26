package ejerciciosvalidadoresjsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

public class ValidaorMovil {

	private Movil movil;

	public ValidaorMovil(Movil movil) {
		super();
		this.movil = movil;
	}
	
	public List<FacesMessage>validar(){
		List<FacesMessage>lErrores=new ArrayList<>();
		
		//Validar todo lo que se necesite para que el móvil sea correcto. 
		lErrores.addAll(this.validarMarca());
		
		return lErrores;
	}
	
	private List<FacesMessage>validarMarca(){
		List<FacesMessage>lErrores=new ArrayList<>();
		
		if(movil.getMarca()==null) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Marca obligatoria", "Marca obligatoria"));
			return lErrores;
		}
		
		if(movil.getMarca().length()<2) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Marca muy corta", "Marca muy corta"));
		}
		
		return lErrores;
	}
}
