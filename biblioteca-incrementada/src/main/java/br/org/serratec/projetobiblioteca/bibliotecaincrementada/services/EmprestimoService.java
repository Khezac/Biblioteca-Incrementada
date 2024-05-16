package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Emprestimo;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
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

	public Emprestimo update(Integer id,Emprestimo novoEmprestimo) {
		Emprestimo emprestimoAtual = emprestimoRepository.findById(id).orElse(null);
		
		if(emprestimoAtual != null) {
			try {
				emprestimoAtual.setData_emprestimo(novoEmprestimo.getData_emprestimo());
				emprestimoAtual.setData_entrega(novoEmprestimo.getData_entrega());
				emprestimoAtual.setValor_emprestimo(novoEmprestimo.getValor_emprestimo());
				emprestimoRepository.save(emprestimoAtual);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
        return emprestimoAtual;
    }

	public Emprestimo delete(Integer id) {
		Emprestimo emprestimoDeletado = emprestimoRepository.findById(id).orElse(null);

		if (emprestimoDeletado != null) {
			try {
				emprestimoRepository.deleteById(id);
				return emprestimoDeletado;

			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return emprestimoDeletado;
	}
	
	public long count() {
		return emprestimoRepository.count();
	}

}
