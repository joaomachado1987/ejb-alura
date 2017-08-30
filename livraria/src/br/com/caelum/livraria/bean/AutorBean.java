package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.service.AutorService;
import br.com.caelum.service.LivrariaException;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorService autorService;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() throws LivrariaException {
		this.autorService.salva(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.autorService.todosAutores();
	}
}
