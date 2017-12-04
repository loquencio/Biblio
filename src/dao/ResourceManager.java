package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ResourceManager {
	private static EntityManagerFactory ef = Persistence.createEntityManagerFactory("BIBLIOTECA");
	
	public static EntityManager getEntityManager() {
		return ef.createEntityManager();
	}
}
