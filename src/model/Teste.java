package model;

import java.text.ParseException;

import dao.AutorDao;
import dao.EditoraDao;
import dao.IAutorDao;
import dao.IEditoraDao;
import dao.ILivroDao;
import dao.LivroDao;

public class Teste {
	public static void main(String[] args) throws ParseException {
		ILivroDao ld = new LivroDao();
		IEditoraDao ed = new EditoraDao();
		IAutorDao ad = new AutorDao();
		Editora e;
		Autor a;

		Livro l = new Livro();
		l.setNome("Subsolo");
		l.setResumo("Felicidade");
		
//		if ((ed.buscaPorNomeIgual("Editora")) == null) {
			e = new Editora();
			e.setNome("Editora");
			ed.persistir(e);
//		} else {
//			e = ed.buscaPorNomeIgual("Editora");
//		}
		
		l.setEditora(e);
		
//		if ((ad.buscaPorNomeIgual("Tururu")) == null) {
			a = new Autor();
			a.setNome("Tururu");
			ad.persistir(a);
//		} else {
//			a = ad.buscaPorNomeIgual("Tururu");
//		}
		
		l.addAutor(a);
		ld.persistir(l);
		
	}
}
