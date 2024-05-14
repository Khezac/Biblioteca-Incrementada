package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Usuario;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) { 
		return usuarioRepository.findById(id).orElse(null); 
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario deleteById(Integer id) {
	Usuario usuarioDeletado = usuarioRepository.findById(id).orElse(null); 
	
		if (usuarioDeletado != null) {
			try {
				
				usuarioRepository.deleteById(id);
				return usuarioDeletado;
				
			} catch (Exception e) {
				System.out.println(e);
			}
		
		}	
		return usuarioDeletado;
	}
}
