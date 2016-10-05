package com.rest.spring.mongo.sample.services.model.service.ibs;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.UsuarioCollection;
import com.rest.spring.mongo.sample.services.model.data.nosql.respository.UsuarioRepository;
import com.rest.spring.mongo.sample.services.model.service.converter.UsuarioConverter;
import com.rest.spring.mongo.sample.services.model.service.domain.Usuario;

/**
 * 
 * Classe que disponbiliza os servicos de negocio
 * internos de Usuario.   
 * 
 * Essa classe tem como atividade fim disponibilizar
 * uma servicos basicos envolvendo o Usuario.
 * 
 * 
 *  @category Classe de Servicos Basicos.
 *
 */
@Service
@Scope(value="prototype")
public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2977418345773540077L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	private CounterService counterService;
	
	 @Autowired 
	 private MongoOperations mongo;

	/**
	 * Registra um novo usuario.
	 * @param usuario - informacoes sobre o novo usuario.
	 */
	public void novo(final Usuario usuario) {	
		
		final UsuarioCollection usuarioCollection = usuarioConverter.converte(usuario, true);		
		usuarioRepository.save(usuarioCollection);
		
		usuario.setId(usuarioCollection.getId());				
	}
	
	/**
	 * Atualiza um usuario existente.
	 * @param usuario - usuario a ser atualizado.
	 */
	public void atualizar(Usuario usuario) {
		
		final UsuarioCollection usuarioCollection = usuarioConverter.converte(usuario, false);
		
		usuarioRepository.save(usuarioCollection);
	}
	
	/**
	 * Recupera um usuario por seu identificador.
	 * @param identificador - id do usuario a se localizado.
	 * @return Usuario - retorna o Usuario localizado.
	 */
	public Usuario recuperaPorIdentificador(Long identificador) {
		return  usuarioConverter.converte(usuarioRepository.findOne(identificador));
	}
	/**
	 * Remove um usuario por seu identificador.
	 * @param identificador - id do usuario a ser removido. 
	 */
	public void removePorIdentificador(Long identificador) {
		usuarioRepository.delete(identificador);		
	}
	
	/**
	 * Lista todos os usuarios utilizando paginacao.
	 * @param pagina - bloco dentro do total de usuarios.
	 * @param total - total dos usuarios.
	 * @return List<Usuario> - retorna uma lista de usuarios.
	 */
	public List<Usuario> listaTodos(final int pagina, final int total){
		Page<UsuarioCollection> usuarios = usuarioRepository.findAll(new PageRequest(pagina, total));
		return usuarioConverter.converte(usuarios.getContent());
	}
	/**
	 * Recupera o usuario por seu nome.
	 * @param nome - nome do usuario a ser localizado.
	 * @return List<Usuario> - retorna uma lista de usuarios que correspondem 
	 * ao nome parametrizado.
	 */
	public List<Usuario> recuperaUsuariosPorNome(final String nome){
		return usuarioConverter.converte(usuarioRepository.findByNome(nome));
	}
	
	/**
	 * Metodo responsavel em verificar as credenciais de um usuario.
	 * @param email - identificador do usuario.
	 * @param senha - senha do usuario.
	 * @return Usuario - retorna o usuario localizado,
	 */
	public Usuario verificaCredenciais(final String email , final String senha){
		
		final Query  query = new Query();
		query.addCriteria(Criteria.where("email").is(email).and("senha").is(senha));
		
		UsuarioCollection usuario = mongo.findOne(query, UsuarioCollection.class);
		
		if (usuario != null){
			return  usuarioConverter.converte(usuario);
		} else {
			return null;
		}
		
	}
	
}
