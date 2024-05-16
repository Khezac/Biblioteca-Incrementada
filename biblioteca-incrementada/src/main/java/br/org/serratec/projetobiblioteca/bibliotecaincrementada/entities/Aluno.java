package br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluno_matricula")
	private Integer aluno_matricula;

	@Column(name = "nome")
	@NotEmpty
	private String nome;

	@Column(name = "data_nascimento")
	@NotNull
	private LocalDate data_nascimento;

	@Column(name = "cpf")
	@NotBlank
	private String cpf;

	@Column(name = "logradouro")
	@NotEmpty
	private String logradouro;

	@Column(name = "numero_logradouro")
	@NotBlank
	private String numero_logradouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	@NotEmpty
	private String bairro;

	@Column(name = "cidade")
	@NotEmpty
	private String cidade;
	
	@OneToMany(mappedBy = "aluno")
	private List<Emprestimo> emprestimo;

	public Aluno() {
	
	}

	public Integer getAluno_matricula() {
		return aluno_matricula;
	}

	public void setAluno_matricula(Integer aluno_matricula) {
		this.aluno_matricula = aluno_matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero_logradouro() {
		return numero_logradouro;
	}

	public void setNumero_logradouro(String numero_logradouro) {
		this.numero_logradouro = numero_logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
