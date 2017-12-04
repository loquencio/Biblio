package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Autor;

public class AutorDao implements IAutorDao{
	
	private EntityManager em;
	
	public AutorDao() {
	}
	
	@Override
	public void persistir(Autor a) {
		em = ResourceManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Autor buscaPorNomeIgual(String nome) {
		em = ResourceManager.getEntityManager();
		TypedQuery<Autor> qry = em.createQuery("select a from autores a where upper(a.nome) = upper(:n)", Autor.class);
		qry.setParameter("n", nome);
		List<Autor> autores = qry.getResultList();
		if (autores.size() > 0)
			return autores.get(0);
		return null;
	}

	@Override
	public List<Autor> buscaPorNomeSimilar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autor buscaPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autor> buscaTodos() {
		em = ResourceManager.getEntityManager();
		TypedQuery<Autor> qry = em.createQuery("select a from autores a", Autor.class);
		List<Autor> autores = qry.getResultList();
		em.close();
		return autores;
	} 

}
