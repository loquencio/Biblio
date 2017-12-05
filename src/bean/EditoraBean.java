package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.EditoraDao;
import dao.IEditoraDao;
import model.Editora;

@ManagedBean
@RequestScoped
public class EditoraBean implements Serializable {
	private static final long serialVersionUID = 8248292245076636203L;
	private IEditoraDao ed = new EditoraDao();

	public List<Editora> completeEditora(String query) {
		List<Editora> filtradas = ed.buscaPorNomeParecido(query);
		if (filtradas.size() <= 0 && !query.isEmpty()) {
			Editora e = new Editora();
			e.setNome(query);
			filtradas.add(e);
		}

		return filtradas;
	}
}
