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
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.EditoraService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/editora")
public class EditoraController {

	@Autowired
	EditoraService editoraService;

	@GetMapping
	public ResponseEntity<List<Editora>> findAll() {
		return new ResponseEntity<>(editoraService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editora> findById(@PathVariable Integer id) {
		Editora editoraId = editoraService.findById(id);
		if (editoraId == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(editoraId, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Editora> save(@RequestBody @Valid Editora editora) {
		return new ResponseEntity<>(editoraService.save(editora), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Editora>update(@PathVariable Integer id, @RequestBody Editora novaEditora){
		Editora editoraUpdate = editoraService.update(id,novaEditora);
		if(editoraUpdate != null) {
			 return new ResponseEntity<>(editoraUpdate, HttpStatus.OK);
		}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Editora> deletaEditora(@PathVariable Integer id) {
		Editora editoraDeletada = editoraService.findById(id);

		if (editoraDeletada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		editoraService.deleteById(id);
		return new ResponseEntity<>(editoraDeletada, HttpStatus.OK);
	}

}
