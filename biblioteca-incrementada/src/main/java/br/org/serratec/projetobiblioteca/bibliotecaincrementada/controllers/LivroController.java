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
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED) ;
	}
	
	@PutMapping
	public ResponseEntity<Livro>update(@RequestBody Livro livro){
        return new ResponseEntity<>(livroService.update(livro), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deletaAluno(@PathVariable Integer id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
}
