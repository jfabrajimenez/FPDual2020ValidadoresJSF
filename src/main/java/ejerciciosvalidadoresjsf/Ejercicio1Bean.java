package ejerciciosvalidadoresjsf;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name = "ejercicio1")
@ViewScoped
public class Ejercicio1Bean implements Serializable {
	private static final long serialVersionUID = -1238900606788062198L;
	
	private Movil movil;

	public Ejercicio1Bean() {
		super();
		
		this.movil=new Movil();
	}
	
	public Date getFechaMaxima() {
		return new Date();
	}
	
	public void guardar() {
		//A este m�todo llego cuando el usuario pulsa el bot�n de guardar en el navegador.
		//En este caso el formulario se habr� validado completamente porque antes de invocar este m�todo se ejecutan todas las validaciones.
		//Alguno os preguntar�is entonces �Por qu� haces un validador para el objeto Movil que valide todo en conjunto si al final lo que se valida es
		//lo mismo que cada validador de forma individual?.
		//La respuesta es �que pasar�a si tienes un servicio web que permita el alta de m�viles?, el servicio web no tiene validadores, �que pasar�a si el usuario es
		//espabilado y entra en las opciones de depuraci�n del navegador y consigue enviar un campo vac�o cuando deber�a estar relleno? para cubrir estas situaciones
		//es obligatorio para mi punto de vista hacer una validaci�n del objeto justo antes de guardarlo o procesarlo y esta validaci�n deber�a hacerce dentro de la transacci�n.
		ValidadorMovil validador=new ValidadorMovil(movil);
		List<FacesMessage>lErrores=validador.validar();
		
		if(lErrores != null && !lErrores.isEmpty()) {
			lErrores.forEach(this::mostrarMensajeEnLaWeb);
		}
		
		System.out.println("El m�vil es completamente v�lido para guardar");
		System.out.println("Guardamos el m�vil");
		
		this.mostrarMensajeEnLaWeb(new FacesMessage(FacesMessage.SEVERITY_INFO, "Movil guardado correctamente", "El m�vil se ha guardado correctamente"));
	}
	
	private void mostrarMensajeEnLaWeb(FacesMessage mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	public Movil getMovil() {
		return movil;
	}

	public void setMovil(Movil movil) {
		this.movil = movil;
	}
	
	

}
