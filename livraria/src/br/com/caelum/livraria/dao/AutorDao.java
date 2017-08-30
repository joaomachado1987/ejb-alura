package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
//@TransactionManagement(TransactionManagementType.BEAN)
//@Interceptors(LogInterceptor.class)
public class AutorDao {

//	@Inject
//	private UserTransaction tx;
	
	@PersistenceContext
	private EntityManager entityManager;
	
//	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
//		try {
//			tx.begin();
			entityManager.persist(autor);
//			tx.commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
	}
	
	public List<Autor> todosAutores() {
		return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
	    return this.entityManager.find(Autor.class, autorId);
	}
	
}
