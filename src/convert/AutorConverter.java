package convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.AutorDao;
import dao.IAutorDao;
import model.Autor;

@FacesConverter(value = "autorConverter")
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			IAutorDao ad = new AutorDao();
			Autor a = ad.buscaPorNomeIgual(value);

			if (a == null) {
				try {
					a = ad.buscaPorId(Long.parseLong(value));
				} catch (NumberFormatException e) {
					a = new Autor();
					a.setNome(value);
				}
			}

			return a;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		if (obj != null) {
			return String.valueOf(((Autor) obj).getId()).equals("0") ? String.valueOf(((Autor) obj).getNome())
					: String.valueOf(((Autor) obj).getId());
		} else {
			return null;
		}
	}

}
