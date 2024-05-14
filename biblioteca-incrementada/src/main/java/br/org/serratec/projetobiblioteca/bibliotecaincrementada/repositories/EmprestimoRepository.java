package br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository <Emprestimo, Integer>{

}
