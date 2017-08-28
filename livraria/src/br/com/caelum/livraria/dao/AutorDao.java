package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateful
public class AutorDao {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void aposCriacao() {
		System.out.println("AutorDao foi Criado (callback)");
	}
	
	public void salva(Autor autor) {
		entityManager.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		return entityManager.find(Autor.class, autorId);
	}
	
}
