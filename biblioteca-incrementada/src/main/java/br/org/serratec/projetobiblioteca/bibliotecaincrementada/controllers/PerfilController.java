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

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Perfil;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	@GetMapping
	public ResponseEntity<List<Perfil>> findAll() {
		return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Perfil> findById(@PathVariable Integer id) {
		Perfil perfilId = perfilService.findById(id);

		if (perfilId == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(perfilId, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Perfil> save(@RequestBody Perfil perfil) {
		return new ResponseEntity<>(perfilService.save(perfil), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Perfil>update(@PathVariable Integer id, @RequestBody Perfil novoPerfil){
		Perfil perfilUpdate = perfilService.update(id,novoPerfil);
		if(perfilUpdate != null) {
			 return new ResponseEntity<>(perfilUpdate, HttpStatus.OK);
		}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Perfil> deletaPerfil(@PathVariable Integer id) {
		Perfil perfilDeletado = perfilService.findById(id);

		if (perfilDeletado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		perfilService.delete(id);
		return new ResponseEntity<>(perfilDeletado, HttpStatus.OK);
	}
}
