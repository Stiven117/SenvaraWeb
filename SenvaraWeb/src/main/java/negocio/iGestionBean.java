package negocio;

import java.util.ArrayList;

//import javax.ejb.Remote;

import entidades.Registromedida;

//@Remote
public interface iGestionBean {
	public ArrayList<Registromedida> obtenerGrafica();		
}
