package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Emprestimo;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories.EmprestimoRepository;


@Service
public class EmprestimoService {
	
	@Autowired
	EmprestimoRepository emprestimoRepository;
	

	public List<Emprestimo> findAll() {
		return emprestimoRepository.findAll();
	}

	public Emprestimo findById(Integer id) { 
		return emprestimoRepository.findById(id).orElse(null); 
	}

	public Emprestimo save(Emprestimo emprestimo) { 
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo update(Emprestimo emprestimo) { 
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo deleteById(Integer id) {
		Emprestimo emprestimoDeletado = emprestimoRepository.findById(id).orElse(null);
		if(emprestimoDeletado != null) {
			try {
				emprestimoRepository.deleteById(id);
				return emprestimoDeletado;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return emprestimoDeletado;
	}
	
	public Emprestimo deleteUsuario(Emprestimo emprestimo) {
		Emprestimo emprestimoDeletado = emprestimoRepository.findById(emprestimo.getEmprestimo_id()).orElse(null);
		if(emprestimoDeletado != null) {
			try {
				emprestimoRepository.delete(emprestimo);
				return emprestimoDeletado;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return emprestimoDeletado;
	}
}

