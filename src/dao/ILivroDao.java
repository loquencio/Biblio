package dao;

import java.util.List;

import model.Livro;

public interface ILivroDao {
	void persistir(Livro l);
	Livro procurar(long id);
	List<Livro> buscarTodos();
}
