package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("LivroDao foi Criado (callback)");
	}
	
	public void salva(Livro livro) {
		entityManager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return entityManager.createQuery("select l from Livro l",Livro.class).getResultList();
	}

	@SuppressWarnings(value="unchecked")
	public List<Livro> recuperaLivrosPeloTitulo(String titulo) {
		Query q = entityManager.createQuery("select l from Livro l where l.titulo like :pTitulo",Livro.class);
		q.setParameter("pTitulo", "%" + titulo + "%");
		return q.getResultList();
	} 
	
}
