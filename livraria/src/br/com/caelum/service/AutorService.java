package br.com.caelum.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	private AutorDao autorDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Autor autor) throws LivrariaException {
		this.autorDao.salva(autor);		
//		throw new LivrariaException();
//		throw new RuntimeException("[ERRO] Erro lançado para testar o rollback da transação.");
	}

	public List<Autor> todosAutores() {
		return this.autorDao.todosAutores();
	}
}
