package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "livros")
@Table(name = "livros")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nome;

	@Column(length = 4000)
	private String resumo;

	@Column(name = "data_de_lancamento")
	private Date lancamento;

	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name = "escrito_por", joinColumns = { @JoinColumn(name = "livro_id") }, inverseJoinColumns = {
			@JoinColumn(name = "autor_id") })
	
	private List<Autor> autores;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "editora_id")
	private Editora editora;

	public Livro() {
	}

	public long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}

	public Date getLancamento() {
		return lancamento;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Editora getEditora() {
		return editora;
	}
	
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
		System.out.println(autores.size());
		for (Autor a : autores)
			System.out.println(a.getNome());
	}
	
	public List<Autor> getAutores() {
		return autores;
	}

	public void addAutor(Autor a) {
		autores.add(a);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", resumo=" + resumo + ", lancamento=" + lancamento
				+ ", autores=]";
	}
}
