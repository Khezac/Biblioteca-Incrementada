package br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
