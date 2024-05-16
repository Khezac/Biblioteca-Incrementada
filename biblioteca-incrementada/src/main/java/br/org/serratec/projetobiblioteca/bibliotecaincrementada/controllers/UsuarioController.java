package br.org.serratec.projetobiblioteca.bibliotecaincrementada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Usuario;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.UsuarioService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return new ResponseEntity<>(usuarioService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) { 
		Usuario UserId = usuarioService.findById(id);
		if(UserId == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(UserId,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario>save(@Valid @RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario>update(@PathVariable Integer id, @RequestBody Usuario novoUsuario){
		Usuario usuarioUpdate = usuarioService.update(id,novoUsuario);
		if(usuarioUpdate != null) {
			 return new ResponseEntity<>(usuarioUpdate, HttpStatus.OK);
		}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
		Usuario usuarioDeletado = usuarioService.findById(id);
		
		if(usuarioDeletado == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			usuarioService.deleteById(id);
		}
		return new ResponseEntity<>(usuarioDeletado,HttpStatus.OK);
	}
}
