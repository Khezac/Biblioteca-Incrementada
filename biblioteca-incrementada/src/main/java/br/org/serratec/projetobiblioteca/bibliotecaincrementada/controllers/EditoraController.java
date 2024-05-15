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

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Editora;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.EditoraService;

@RestController
@RequestMapping("/editora")
public class EditoraController {

	@Autowired
	EditoraService editoraService;
	
	@GetMapping
	public ResponseEntity<List<Editora>> findAll() {
		return new ResponseEntity<>(editoraService.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editora> findById(@PathVariable Integer id) { 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Editora> save(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.save(editora), HttpStatus.CREATED) ;
	}
	
	@PutMapping
	public ResponseEntity<Editora>update(@RequestBody Editora editora){
        return new ResponseEntity<>(editoraService.update(editora), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Editora> deletaEditora(@PathVariable Integer id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}	

}