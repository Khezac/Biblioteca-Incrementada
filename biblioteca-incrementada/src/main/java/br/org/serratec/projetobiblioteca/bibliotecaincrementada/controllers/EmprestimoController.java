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

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Emprestimo;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;

	@GetMapping
	public ResponseEntity<List<Emprestimo>> findAll() {
		return new ResponseEntity<>(emprestimoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> findById(@PathVariable Integer id) {
		Emprestimo emprestimoId = emprestimoService.findById(id);

		if (emprestimoId == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(emprestimoId, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Emprestimo> save(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.save(emprestimo), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Emprestimo> update(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.update(emprestimo), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Emprestimo> deletaEmprestimo(@PathVariable Integer id) {
		Emprestimo emprestimoDeletado = emprestimoService.findById(id);

		if (emprestimoDeletado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		emprestimoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
