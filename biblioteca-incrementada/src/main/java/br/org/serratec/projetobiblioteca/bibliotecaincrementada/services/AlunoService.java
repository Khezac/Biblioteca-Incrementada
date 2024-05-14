package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Aluno;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	public Aluno findById(Integer id) { 
		return alunoRepository.findById(id).orElse(null); 
	}

	public Aluno save(Aluno aluno) { 
		return alunoRepository.save(aluno);
	}

	public Aluno update(Aluno aluno) { 
		return alunoRepository.save(aluno);
	}

	public Aluno deleteById(Integer id) {
		Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
		if(alunoDeletado != null) {
			try {
				alunoRepository.deleteById(id);
				return alunoDeletado;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return alunoDeletado;
	}
	
	public Aluno deleteUsuario(Aluno aluno) {
		Aluno alunoDeletado = alunoRepository.findById(aluno.getAluno_matricula()).orElse(null);
		if(alunoDeletado != null) {
			try {
				alunoRepository.delete(aluno);
				return alunoDeletado;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return alunoDeletado;
	}
}
