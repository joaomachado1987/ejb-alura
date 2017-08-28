package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless	
public class UsuarioDao {

	private Banco banco = new Banco();

	@PostConstruct
	public void aposCriacao() {
		System.out.println("UsuarioDao foi Criado (callback)");
	}
	
	public Usuario buscaPeloLogin(String login) {
		return this.banco.buscaPeloNome(login);
	}
	
}
