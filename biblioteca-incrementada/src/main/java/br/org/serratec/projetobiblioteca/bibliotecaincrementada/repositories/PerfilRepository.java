package br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil,Integer> {

}
