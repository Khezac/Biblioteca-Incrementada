package br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "editora_id")
	private Integer editora_id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "imagem_nome")
	private String imagem_nome;
	
	@Column(name = "imagem_filename")
	private String imagem_filename;

	@Column(name = "imagem_url")
	private String imagem_url;
	
	@OneToMany(mappedBy = "editora")
	private List<Livro> livros;
	
	public Editora() {
	}

	public Editora( String nome, String imagem_nome, String imagem_filename, String imagem_url,
		List<Livro> livros) {
		this.nome = nome;
		this.imagem_nome = imagem_nome;
		this.imagem_filename = imagem_filename;
		this.imagem_url = imagem_url;
		this.livros = livros;
	}


	public Integer getEditora_id() {
		return editora_id;
	}


	public void setEditora_id(Integer editora_id) {
		this.editora_id = editora_id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getImagem_nome() {
		return imagem_nome;
	}


	public void setImagem_nome(String imagem_nome) {
		this.imagem_nome = imagem_nome;
	}


	public String getImagem_filename() {
		return imagem_filename;
	}


	public void setImagem_filename(String imagem_filename) {
		this.imagem_filename = imagem_filename;
	}


	public String getImagem_url() {
		return imagem_url;
	}


	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}


	public List<Livro> getLivros() {
		return livros;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
	
}
