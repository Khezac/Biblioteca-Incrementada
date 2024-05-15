package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Editora;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	EditoraRepository editoraRepository;
	
	public List<Editora> findAll(){
		return editoraRepository.findAll();
	}
	public Editora findById(Integer id) { 
		return editoraRepository.findById(id).orElse(null); 
	}

	public Editora save(Editora editora) { 
		return editoraRepository.save(editora);
	}

	public Editora update(Editora editora) { 
		return editoraRepository.save(editora);
	}

	public Editora deleteById(Integer id) {
		Editora editoraDeletada = editoraRepository.findById(id).orElse(null);
		if(editoraDeletada != null) {
			try {
				editoraRepository.deleteById(id);
				return editoraDeletada;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return editoraDeletada;
	}

}
