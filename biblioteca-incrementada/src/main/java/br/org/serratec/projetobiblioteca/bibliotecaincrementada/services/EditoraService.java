package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Editora;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
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

	public Editora update(Integer id,Editora novaEditora) {
		Editora editoraAtual = editoraRepository.findById(id).orElse(null);
		if(editoraAtual != null) {
			try {
				editoraAtual.setNome(novaEditora.getNome());
				editoraAtual.setImagem_nome(novaEditora.getImagem_nome());
				editoraAtual.setImagem_filename(novaEditora.getImagem_filename());
				editoraAtual.setImagem_url(novaEditora.getImagem_url());
				editoraRepository.save(editoraAtual);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
        return editoraAtual;
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
