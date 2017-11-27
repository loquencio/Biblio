package dao;

import model.Livro;

public interface ILivroDao {
	void persistir(Livro l);
	Livro procurar(long id);
}
