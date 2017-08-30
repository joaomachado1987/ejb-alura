package br.com.caelum.livraria.webservices;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@WebService(name="livrariaWS")
public class LivrariaWS {
	
	@Inject
	private LivroDao livroDao;
	
	@WebResult(name="livros")
	public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String titulo){
		return this.livroDao.recuperaLivrosPeloTitulo(titulo);
	}
	
}
