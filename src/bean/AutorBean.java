package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AutorDao;
import dao.IAutorDao;
import model.Autor;

@ManagedBean
@SessionScoped
public class AutorBean {
	private IAutorDao ad = new AutorDao();
	
	public List<Autor> completeAutor(String query) {
		List<Autor> filtrados = ad.buscaPorNomeSimilar(query);
		System.out.println(filtrados.size());
		if (filtrados.size() <= 0 && !query.isEmpty()) {
			Autor a = new Autor();
			a.setNome(query);
			filtrados.add(a);
		}
		
		return filtrados;
	}
}
