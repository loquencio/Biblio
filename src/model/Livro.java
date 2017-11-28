package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "livros")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String nome;

	@Column(length = 500)
	private String resumo;

	@Column(name = "data_de_lancamento")
	private Date lancamento;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "escrito_por", joinColumns = { @JoinColumn(name = "livro_id") }, inverseJoinColumns = {
			@JoinColumn(name = "autor_id") })
	private Set<Autor> autores;

	public Livro() {

	}
	
	public long getId() {
		return id;
	}
	
	public void setNome(String nome){
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
	
	public void addAutor(Autor a){
		autores.add(a);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", resumo=" + resumo + ", lancamento=" + lancamento
				+ ", autores=]";
	}
}
