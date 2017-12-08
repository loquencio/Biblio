package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PostRemove;
import javax.persistence.TypedQuery;

import model.Livro;

public class LivroDao implements ILivroDao {

	private EntityManager em;

	public LivroDao() {
	}

	@Override
	public void persistir(Livro l) {
		em = ResourceManager.getEntityManager();
		em.getTransaction().begin();
		if (em.find(Livro.class, (long) l.getId()) != null)
			em.merge(l);
		else 
			em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Livro buscaPorId(long id) {
		em = ResourceManager.getEntityManager();
		Livro l = em.find(Livro.class, (long) id);
		em.close();
		return l;
	}

	@Override
	public List<Livro> buscarTodos() {
		em = ResourceManager.getEntityManager();
		List<Livro> livros = em.createQuery("select l from livros l", Livro.class).getResultList();
		return livros;
	}

	@Override
	public List<Livro> buscaPorNome(String nome) {
		em = ResourceManager.getEntityManager();
		TypedQuery<Livro> qry = em.createQuery("select l from livros l where l.nome like :n", Livro.class);
		qry.setParameter("n", "%" + nome + "%");
		em.close();
		return qry.getResultList();
	}

	@Override
	public void remover(long id) {
		em = ResourceManager.getEntityManager();
		em.getTransaction().begin();
		Livro l = em.find(Livro.class, (long) id);
		if (l != null) {
			em.remove(l);
		}
		em.getTransaction().commit();
		em.close();
	}
}
