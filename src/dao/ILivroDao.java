package dao;

import java.util.List;

import model.Livro;

public interface ILivroDao {
	void persistir(Livro l);
	Livro buscaPorId(long id);
	List<Livro> buscarTodos();
	List<Livro> buscaPorNome(String nome);
}
