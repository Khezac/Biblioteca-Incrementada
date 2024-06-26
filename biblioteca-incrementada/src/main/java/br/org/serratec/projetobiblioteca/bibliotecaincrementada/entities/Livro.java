package br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "livro")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "livro_id",
		scope = Livro.class
)
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_id")
	private Integer livro_id;
	
	@Column(name = "nome_livro")
	@NotBlank
	private String nome_livro;
	
	@Column(name = "nome_autor")
	@NotBlank
	private String nome_autor;
	
	@Column(name = "data_lancamento")
	@NotNull
	private LocalDate data_lancamento;
	
	@Column(name = "codigo_isbn")
	@Min(value = 1)
	@NotNull
	private Integer codigo_isbn;
	
	@ManyToOne
	@JoinColumn(name="editora_id", referencedColumnName="editora_id")
	@NotNull
	private Editora editora;
	
	public Livro() {

	}

	public Livro(Integer livro_id, String nome_livro, String nome_autor, LocalDate data_lancamento, Integer codigo_isbn,
			Editora editora) {
		this.nome_livro = nome_livro;
		this.nome_autor = nome_autor;
		this.data_lancamento = data_lancamento;
		this.codigo_isbn = codigo_isbn;
		this.editora = editora;
	}

	public Integer getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(Integer livro_id) {
		this.livro_id = livro_id;
	}

	public String getNome_livro() {
		return nome_livro;
	}

	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public LocalDate getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public Integer getCodigo_isbn() {
		return codigo_isbn;
	}

	public void setCodigo_isbn(Integer codigo_isbn) {
		this.codigo_isbn = codigo_isbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	
}
