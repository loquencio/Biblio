package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Livro;

public class LivroDao implements ILivroDao{
	
	private static EntityManagerFactory ef = Persistence.createEntityManagerFactory("BIBLIOTECA");
	private static EntityManager em = ef.createEntityManager();
		
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

	@Override
	public List<Livro> buscarTodos() {
		return em.createQuery("select l from livros l", Livro.class).getResultList();
	}

}
