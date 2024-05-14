package br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
