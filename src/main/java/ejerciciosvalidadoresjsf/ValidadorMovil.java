package ejerciciosvalidadoresjsf;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

public class ValidadorMovil {

	private Movil movil;

	public ValidadorMovil(Movil movil) {
		super();
		this.movil = movil;
	}
	
	public List<FacesMessage>validar(){
		List<FacesMessage>lErrores=new ArrayList<>();
		
		//Validar todo lo que se necesite para que el móvil sea correcto. 
		lErrores.addAll(this.validarMarca());
		lErrores.addAll(this.validarColor());
		lErrores.addAll(this.validarSistemaOperativo());
		lErrores.addAll(this.validarVersion());
		lErrores.addAll(this.validarRam());
		lErrores.addAll(this.validarPrecio());
		lErrores.addAll(this.validarFechaVenta());
		lErrores.addAll(this.validarDescripcion());
		
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
	
	private List<FacesMessage>validarColor(){
		if(movil.getColor()==null) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Color obligatorio", "Color obligatorio"));
		}
		
		ValidadorColoresMovilPermitidos validador=new ValidadorColoresMovilPermitidos();
		return validador.validar(movil.getColor());
	}
	
	private List<FacesMessage>validarSistemaOperativo(){
		if(movil.getSo()==null) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistema Operativo obligatorio", "Sistema Operativo obligatorio"));
		}
		
		ValidadorSistemasOperativosPermitidos validador=new ValidadorSistemasOperativosPermitidos();
		validador.setMarca(this.movil.getMarca());
		return validador.validar(movil.getSo());
	}
	
	private List<FacesMessage>validarVersion(){
		if(movil.getVersion()==null) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Versión obligatoria", "Versión obligatoria"));
		}
		return Collections.emptyList();
	}
	
	private List<FacesMessage>validarRam(){
		if(movil.getSo()==null) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "RAM obligatoria", "RAM obligatoria"));
		}
		
		ValidadorRam validador=new ValidadorRam();
		validador.setMarca(this.movil.getMarca());
		return validador.validar(movil.getRam());
	}
	
	private List<FacesMessage>validarPrecio(){
		if(movil.getPrecio()==null) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Precio obligatorio", "Precio obligatorio"));
		}
		
		List<FacesMessage>lErrores=new ArrayList<>();
		
		if(this.movil.getPrecio().compareTo(BigDecimal.ZERO)<0) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, precio negativo", "El precio tiene que ser mayor que cero"));
		}
		
		return lErrores;
	}
	
	private List<FacesMessage>validarFechaVenta(){
		if(movil.getFechaVenta()==null) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fecha de venta obligatoria", "Fecha de venta obligatoria"));
		}
		
		List<FacesMessage>lErrores=new ArrayList<>();
		
		if(movil.getFechaVenta().before(Date.from(LocalDate.of(2011, Month.JANUARY, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, fecha anterior a la permitida", "La fecha no puede ser anterior al año 2011"));
		}
		
		if(movil.getFechaVenta().after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error, fecha posterior a la permitida", "La fecha no puede ser del futuro"));
		}
		
		return lErrores;
	}
	
	private List<FacesMessage>validarDescripcion(){
		if(movil.getDescripcion()==null || movil.getDescripcion().isEmpty()) {
			return Arrays.asList(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Descripción obligatoria", "Descripción obligatoria"));
		}
		
		List<FacesMessage>lErrores=new ArrayList<>();
		
		if(this.movil.getDescripcion().length()>255) {
			lErrores.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Descripción muy larga", "La descripción no puede tener más de 255 caracteres"));
		}
		
		return lErrores;
	}
}
