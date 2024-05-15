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

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Aluno;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.services.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	 
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> aluno = alunoService.findAll();
		if(aluno != null)
			return new ResponseEntity<>(alunoService.findAll(),HttpStatus.OK);
		else
			return new ResponseEntity<>(alunoService.findAll(),HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) { 
		Aluno aluno = alunoService.findById(id);
		if(aluno != null)
			return new ResponseEntity<>(alunoService.findById(id),HttpStatus.OK);
		else
			return new ResponseEntity<>(alunoService.findById(id),HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED) ;
	}
	
	@PutMapping
	public ResponseEntity<Aluno>update(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.update(aluno), HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deletaAluno(@PathVariable Integer id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
}
