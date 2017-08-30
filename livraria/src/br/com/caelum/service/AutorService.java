package br.com.caelum.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	private AutorDao autorDao;
	
	public void salva(Autor autor) {
		this.autorDao.salva(autor);		
	}

	public List<Autor> todosAutores() {		
		return this.autorDao.todosAutores();
	}
}
