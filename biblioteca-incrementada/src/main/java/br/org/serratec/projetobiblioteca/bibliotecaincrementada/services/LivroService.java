package br.org.serratec.projetobiblioteca.bibliotecaincrementada.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projetobiblioteca.bibliotecaincrementada.entities.Livro;
import br.org.serratec.projetobiblioteca.bibliotecaincrementada.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> findAll() {
		return livroRepository.findAll();
	}
	
	public Livro findById(Integer id) { 
		return livroRepository.findById(id).orElse(null);
	}
	
	public Livro save(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro update(Integer id,Livro novoLivro) {
		Livro livroAtual = livroRepository.findById(id).orElse(null);
		if(livroAtual != null) {
			try {
				livroAtual.setNome_livro(novoLivro.getNome_livro());
				livroAtual.setNome_autor(novoLivro.getNome_autor());
				livroAtual.setData_lancamento(novoLivro.getData_lancamento());
				livroAtual.setCodigo_isbn(novoLivro.getCodigo_isbn());
				livroRepository.save(livroAtual);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
        return livroAtual;
    }
	
	
	public Livro delete(Integer id) {
		Livro livroDeletado = livroRepository.findById(id).orElse(null);
		if (livroDeletado != null) {
			try {
				livroRepository.deleteById(id);
				return livroDeletado;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return livroDeletado;
		
	}
	
	public long count() {
		return livroRepository.count();
	}
 }
