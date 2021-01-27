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
		//A este método llego cuando el usuario pulsa el botón de guardar en el navegador.
		//En este caso el formulario se habrá validado completamente porque antes de invocar este método se ejecutan todas las validaciones.
		//Alguno os preguntaréis entonces ¿Por qué haces un validador para el objeto Movil que valide todo en conjunto si al final lo que se valida es
		//lo mismo que cada validador de forma individual?.
		//La respuesta es ¿que pasaría si tienes un servicio web que permita el alta de móviles?, el servicio web no tiene validadores, ¿que pasaría si el usuario es
		//espabilado y entra en las opciones de depuración del navegador y consigue enviar un campo vacío cuando debería estar relleno? para cubrir estas situaciones
		//es obligatorio para mi punto de vista hacer una validación del objeto justo antes de guardarlo o procesarlo y esta validación debería hacerce dentro de la transacción.
		ValidadorMovil validador=new ValidadorMovil(movil);
		List<FacesMessage>lErrores=validador.validar();
		
		if(lErrores != null && !lErrores.isEmpty()) {
			lErrores.forEach(this::mostrarMensajeEnLaWeb);
		}
		
		System.out.println("El móvil es completamente válido para guardar");
		System.out.println("Guardamos el móvil");
		
		this.mostrarMensajeEnLaWeb(new FacesMessage(FacesMessage.SEVERITY_INFO, "Movil guardado correctamente", "El móvil se ha guardado correctamente"));
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
