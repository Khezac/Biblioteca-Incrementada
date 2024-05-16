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
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {
	 
	@Autowired
	LivroService livroService ;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		return new ResponseEntity<>(livroService.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro livroId = livroService.findById(id);

		if (livroId == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(livroId, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro>update(@PathVariable Integer id, @RequestBody Livro novoLivro){
		Livro livroUpdate = livroService.update(id,novoLivro);
		if(livroUpdate != null) {
			 return new ResponseEntity<>(livroUpdate, HttpStatus.OK);
		}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deletaPerfil(@PathVariable Integer id) {
		Livro livroDeletado = livroService.findById(id);

		if (livroDeletado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		livroService.delete(id);
		return new ResponseEntity<>(livroDeletado, HttpStatus.OK);
	}
	
}
