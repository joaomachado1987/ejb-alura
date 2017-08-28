package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	private Banco banco = new Banco();
	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("LivroDao foi Criado (callback)");
	}
	
	public void salva(Livro livro) {
		banco.save(livro);
	}
	
	public List<Livro> todosLivros() {
		return banco.listaLivros();
	}
	
}
