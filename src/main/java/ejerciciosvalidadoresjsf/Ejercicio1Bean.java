package ejerciciosvalidadoresjsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "ejercicio1")
@RequestScoped
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
		
		
		System.out.println("Llega al método de guardar");
	}

	public Movil getMovil() {
		return movil;
	}

	public void setMovil(Movil movil) {
		this.movil = movil;
	}
	
	

}
