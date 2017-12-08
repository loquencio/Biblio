package convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import dao.EditoraDao;
import dao.IEditoraDao;
import model.Autor;
import model.Editora;

@FacesConverter("editoraConverter")
public class EditoraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		System.out.println("getASObject Editora");
		if (value != null && value.trim().length() > 0) {

			IEditoraDao ed = new EditoraDao();
			Editora e = ed.buscaPorNomeIgual(value);
			System.out.println(value);
			if (e == null) {
				try {
					e = ed.buscaPorId(Long.parseLong(value));
				} catch (NumberFormatException ex) {

				}
				if (e == null) {
					e = new Editora();
					e.setNome(value);
				}
			}

			return e;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		System.out.println("getASString editora");
		if (obj != null) {
			System.out.println(String.valueOf(((Editora) obj).getId()).equals("0") ? String.valueOf(((Editora) obj).getNome())
					: String.valueOf(((Editora) obj).getId()) + " retorno getass editora");
			return String.valueOf(((Editora) obj).getId()).equals("0") ? String.valueOf(((Editora) obj).getNome())
					: String.valueOf(((Editora) obj).getId());
		} else {
			return null;
		}
	}

}
