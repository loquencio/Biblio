package model;

import java.text.ParseException;
import java.util.Date;

import dao.ILivroDao;
import dao.LivroDao;

public class Teste {
	public static void main(String[] args) throws ParseException {
		ILivroDao ld = new LivroDao();
		
		Livro l = ld.procurar(1);
		
		l.setNome("t2");
		
		ld.persistir(l);
	}
}
