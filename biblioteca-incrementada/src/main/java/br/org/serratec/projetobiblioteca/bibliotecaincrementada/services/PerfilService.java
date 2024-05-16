package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Perfil;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}
	
	public Perfil findById(Integer id) { 
		return perfilRepository.findById(id).orElse(null);
	}
	
	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public Perfil update(Integer id,Perfil novoPerfil) {
		Perfil perfilAtual = perfilRepository.findById(id).orElse(null);
		if(perfilAtual != null) {
			try {
				perfilAtual.setNome(novoPerfil.getNome());
				perfilAtual.setDescricao(novoPerfil.getDescricao());
				perfilRepository.save(perfilAtual);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
        return perfilAtual;
    }
	
	
	public Perfil delete(Integer id) {
		Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
			
		if(perfilDeletado != null) {
			try {
				perfilRepository.deleteById(id);
				return perfilDeletado;
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
			return perfilDeletado;
		
	}
	
	public long count() {
		return perfilRepository.count();
	}
 }
