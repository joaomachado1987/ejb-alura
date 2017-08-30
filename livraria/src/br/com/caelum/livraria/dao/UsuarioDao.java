package br.com.caelum.livraria.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless	
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDao {

	@PersistenceContext
    private EntityManager manager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario buscaPeloLogin(String login) {
		Usuario usuario = null;
		
		try {
        	usuario = (Usuario) this.manager.createQuery("select u from Usuario u where u.login=:pLogin").setParameter("pLogin", login).getSingleResult();
		}	
        catch (Exception e) {
        	if(usuario==null){
            	usuario = new Usuario();
            	usuario.setLogin("admin");
            	usuario.setSenha("pass");
         		this.manager.persist(usuario);
            }
		}
        
        
        return usuario;
    }
	
}
