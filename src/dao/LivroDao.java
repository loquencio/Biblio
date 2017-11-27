package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Livro;

public class LivroDao implements ILivroDao{

	private static EntityManager em = (Persistence.createEntityManagerFactory("BIBLIOTECA")).createEntityManager();
		
	@Override
	public void persistir(Livro l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
	}

	@Override
	public Livro procurar(long id) {
		return em.find(Livro.class, (long) id);
	}

}
