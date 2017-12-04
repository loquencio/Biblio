package dao;

import java.util.List;

import model.Autor;

public interface IAutorDao {
	void persistir(Autor a);
	Autor buscaPorNomeIgual(String nome);
	List<Autor> buscaPorNomeSimilar(String nome);
	List<Autor> buscaTodos();
	Autor buscaPorId(long id);
}
