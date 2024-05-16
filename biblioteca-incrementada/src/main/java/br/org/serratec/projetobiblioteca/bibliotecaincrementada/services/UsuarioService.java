package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
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
	
	public Usuario update(Integer id,Usuario novoUsuario) {
		Usuario usuarioAtual = usuarioRepository.findById(id).orElse(null);
		if(usuarioAtual != null) {
			try {
				usuarioAtual.setUser_nome(novoUsuario.getUser_nome());
				usuarioAtual.setUser_email(novoUsuario.getUser_email());
				usuarioAtual.setUser_password(novoUsuario.getUser_password());
				usuarioRepository.save(usuarioAtual);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
        return usuarioAtual;
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
