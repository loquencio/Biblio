package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "editoras")
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String nome;

	/*
	 * @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL, targetEntity =
	 * Livro.class) private List<Livro> livros;
	 */
	public Editora() {
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
