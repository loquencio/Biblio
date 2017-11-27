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
	private String descricao;

	@Column(name = "data_de_lancamento")
	private Date lancamento;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "escrito_por", joinColumns = { @JoinColumn(name = "livro_id") }, inverseJoinColumns = {
			@JoinColumn(name = "autor_id") })
	private Set<Autor> autores;

	public Livro(String nome, String descricao, Date lancamento) {
		// this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.lancamento = lancamento;
	}

	public Livro() {

	}

	public void addAutor(Autor a){
		autores.add(a);
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", lancamento=" + lancamento
				+ ", autores=" + nomesDosAutores() + "]";
	}
	
	public String nomesDosAutores(){
		String nomes = "";
		
		for (Autor a : autores){
			nomes += a.getNome() + ", ";
		}
		
		return nomes;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
