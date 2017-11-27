package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import dao.ILivroDao;
import dao.LivroDao;
import model.Livro;

@ManagedBean
@RequestScoped
@URLMappings(mappings = { @URLMapping(id = "livros-index-1", pattern = "/livro", viewId = "/livro/index.xhtml"),
		@URLMapping(id = "livros-index-2", pattern = "/livro/", viewId = "/livro/index.xhtml") })
public class LivroBean implements Serializable {
	private static final long serialVersionUID = 3295081925699767392L;
	private Livro livroAtual = new Livro();
	private ILivroDao ld = new LivroDao();
	private List<Livro> livros = ld.buscarTodos();
	
	public void setLivroAtual(Livro l) {
		this.livroAtual = l;
	}
	public Livro getLivroAtual() {
		return livroAtual;
	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public List<Livro> getLivros(){
		return livros;
	}

	public void adicionar() {
		if (livroAtual != null) {
			ld.persistir(livroAtual);
			livroAtual = new Livro();
			FacesMessage msg = new FacesMessage("Livro adicionado!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
}