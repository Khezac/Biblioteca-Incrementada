package br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emprestimo_id")
	private Integer emprestimo_id;
	
	@Column(name = "livro_id")
	private int livro_Id;
	
	@Column(name = "data_emprestimo")
	private LocalDate data_emprestimo;
	
	@Column(name = "data_entrega")
	private LocalDate data_entrega;
	
	@Column(name = "valor_emprestimo")
	private Float valor_emprestimo;
	
	@ManyToOne
	@JoinColumn(name = "aluno_matricula")
	private Aluno aluno;
	

	public Emprestimo() {
	}


	public Integer getEmprestimo_id() {
		return emprestimo_id;
	}

	public void setEmprestimo_id(Integer emprestimo_id) {
		this.emprestimo_id = emprestimo_id;
	}

	public Integer getAluno() {
		return aluno.getAluno_matricula();
	}

	public void setAluno_matricula(Integer aluno_matricula) {
		this.aluno = aluno_matricula;
	}

	public int getLivro_Id() {
		return livro_Id;
	}

	public void setLivro_Id(int livro_Id) {
		this.livro_Id = livro_Id;
	}

	public LocalDate getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(LocalDate data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public LocalDate getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(LocalDate data_entrega) {
		this.data_entrega = data_entrega;
	}

	public Float getValor_emprestimo() {
		return valor_emprestimo;
	}

	public void setValor_emprestimo(Float valor_emprestimo) {
		this.valor_emprestimo = valor_emprestimo;
	}
	
	
	
	
	

}
