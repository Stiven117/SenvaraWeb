package negocio;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.RegistromedidaDAO;
import entidades.Registromedida;


@Stateless
public class GestionBean{
@Inject
RegistromedidaDAO registromedidaDAO;

public ArrayList<Registromedida> obtenerGraficaDeNodo(int idNodo) {
	List listaRegistros = registromedidaDAO.consultarRegistros();
	ArrayList<Registromedida> registros = new ArrayList<>();
	for (Object registro: listaRegistros)
	{
		Registromedida reg=(Registromedida) registro;
		if(reg.getSensor().getNombre().startsWith("Temperatura") 
				&& reg.getSensor().getNodo().getIdNodo() == idNodo)
		{
			registros.add(reg);
		}
		
	}
	return registros;
}

}
