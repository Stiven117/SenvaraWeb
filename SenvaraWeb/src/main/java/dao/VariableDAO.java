package dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Registromedida;


public class VariableDAO {
	@PersistenceContext
	EntityManager manager;
		
	public Registromedida consultarTemp (String temperatura){
		return manager.find(Registromedida.class, temperatura);
	}
/*
    public void actualizarVariable(Registromedida Variable){
    	Registromedida variableBD = manager.find(Registromedida.class, Registromedida.getId());
	libroEnBD.setTitulo(libro.getTitulo());
	      libroEnBD.setAutor(libro.getAutor());
	libroEnBD.setArea(libro.getArea());
	libroEnBD.setEstudiantePrestado(libro.getEstudiantePrestado());
	libroEnBD.setEtiquetaReserva(libro.getEtiquetaReserva());
	libroEnBD.setFechaLimiteEntrega(libro.getEtiquetaReserva());
}*/
}
