package dao;

import java.util.List;

import model.Editora;

public interface IEditoraDao {
	void persistir(Editora e);
	List<Editora> buscaTodas();
	Editora buscaPorId(long id);
	Editora buscaPorNomeIgual(String nome);
}
