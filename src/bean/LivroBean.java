package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import dao.AutorDao;
import dao.EditoraDao;
import dao.IAutorDao;
import dao.IEditoraDao;
import dao.ILivroDao;
import dao.LivroDao;
import model.Autor;
import model.Livro;

@ManagedBean
@ViewScoped
@URLMappings(mappings = { @URLMapping(id = "livros-index-1", pattern = "/livro", viewId = "/livro/index.xhtml"),
		@URLMapping(id = "livros-index-2", pattern = "/livro/", viewId = "/livro/index.xhtml"),
		@URLMapping(id = "livros-add", pattern = "/livro/add", viewId = "/livro/create.xhtml"),
		@URLMapping(id = "livros-detalhe", pattern = "/livro/detalhe/#{id : livroBean.id}", viewId = "/livro/detalhe.xhtml") })
public class LivroBean implements Serializable {
	private static final long serialVersionUID = 3295081925699767392L;
	private Livro livroAtual = new Livro();
	private ILivroDao ld = new LivroDao();
	private List<Livro> livros = ld.buscarTodos();
	private IEditoraDao ed = new EditoraDao();
	private IAutorDao ad = new AutorDao();
	private long id;
	private Livro livroSelecionado = new Livro();

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setLivroSelecionado(Livro l) {
		System.out.println("get " + l.getId() + l.getNome());
		this.livroSelecionado = l;
	}

	public Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroAtual(Livro l) {
		this.livroAtual = l;
	}

	public Livro getLivroAtual() {
		return livroAtual;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void adicionar() {
		System.out.println(livroAtual.getAutores().size());

		// persiste editora se não existe na base
		if (ed.buscaPorNomeIgual(livroAtual.getEditora().getNome()) == null)
			ed.persistir(livroAtual.getEditora());

		System.out.println("Adicionar livro");
		// persiste autor se não existe na base
		for (Autor a : livroAtual.getAutores()) {
			System.out.println(a.getNome());
			if (ad.buscaPorNomeIgual(a.getNome()) == null)
				ad.persistir(a);
		}

		// persiste livro
		ld.persistir(livroAtual);
		livroAtual = new Livro();
		FacesMessage msg = new FacesMessage("Livro adicionado!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	@URLAction(mappingId = "livros-detalhe")
	public String buscar() {
		livroAtual = ld.buscaPorId(id);

		if (livroAtual == null)
			return "pretty:livros-index-1";

		return "null";
	}

	public String excluir() {
		System.out.println("Tá me chamando sim");
		if (livroSelecionado != null) {
			System.out.println(livroSelecionado.getId()  + livroSelecionado.getNome());
			ld.remover(livroSelecionado.getId());
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Livro removido!", "Livro removido!");
		} else {
			System.out.println("Tô nulo");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Livro não encontrado!",
					"Livro não encontrado!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return "pretty:livros-index-1";
	}
}
