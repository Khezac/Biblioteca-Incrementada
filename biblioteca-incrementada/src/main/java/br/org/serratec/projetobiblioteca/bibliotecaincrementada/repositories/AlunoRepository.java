package br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
