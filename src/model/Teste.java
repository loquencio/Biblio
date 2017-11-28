package model;

import java.text.ParseException;
import java.util.Date;

import dao.ILivroDao;
import dao.LivroDao;

public class Teste {
	public static void main(String[] args) throws ParseException {
		ILivroDao ld = new LivroDao();
		Livro l = new Livro();
		l.setNome("Teste");
		l.setResumo("á é í ó ú");
		ld.persistir(l);
	}
}
