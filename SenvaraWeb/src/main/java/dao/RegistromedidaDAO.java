package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RegistromedidaDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public List consultarRegistros()
		{
			return manager.createQuery("SELECT r FROM Registromedida r").getResultList();
		}
	}
