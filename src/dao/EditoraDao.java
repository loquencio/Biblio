package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Editora;

public class EditoraDao implements IEditoraDao {
	private EntityManager em;

	public EditoraDao() {
	}

	@Override
	public void persistir(Editora e) {
		em = ResourceManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Editora> buscaTodas() {
		em = ResourceManager.getEntityManager();

		TypedQuery<Editora> qry = em.createQuery("select e from editoras e", Editora.class);
		List<Editora> editoras = qry.getResultList();
		em.close();
		return editoras;
	}

	@Override
	public Editora buscaPorId(long id) {
		em = ResourceManager.getEntityManager();

		Editora e = em.find(Editora.class, (long) id);
		em.close();
		return e;
	}

	@Override
	public Editora buscaPorNomeIgual(String nome) {
		em = ResourceManager.getEntityManager();

		TypedQuery<Editora> qry = em.createQuery("select e from editoras e where e.nome = :n", Editora.class);
		qry.setParameter("n", nome);
		List<Editora> editoras = qry.getResultList();

		if (editoras.size() > 0)
			return editoras.get(0);

		return null;
	}

}
