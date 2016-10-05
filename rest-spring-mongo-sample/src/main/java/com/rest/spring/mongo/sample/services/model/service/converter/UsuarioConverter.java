package com.rest.spring.mongo.sample.services.model.service.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.UsuarioCollection;
import com.rest.spring.mongo.sample.services.model.data.nosql.respository.UsuarioRepository;
import com.rest.spring.mongo.sample.services.model.service.domain.Usuario;
import com.rest.spring.mongo.sample.services.model.service.ibs.CounterService;


@Component
@Scope(value="prototype")
public class UsuarioConverter {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CounterService counterService;	
	
	/**
	 * Converte um Usuario em um UsuarioCollection.
	 * @param usuario - objeto a ser convertido.
	 * @return UsuarioCollection - retorna um UsuarioCollection carregado.
	 */
	public UsuarioCollection converte (final Usuario usuario, final boolean novoUsuario){
		
		final UsuarioCollection usuarioCollection = new UsuarioCollection();		
		
		if (novoUsuario){
			usuarioCollection.setId(counterService.getNextSequence("usuarios"));			
			usuarioCollection.setDataCriacao(new Date());

		}else{
			usuarioCollection.setId(usuario.getId());
			usuarioCollection.setStatus(usuario.getStatus());
			usuarioCollection.setDataCriacao(usuario.getDataCriacao());
		}
		
		usuarioCollection.setDataRemocao(usuario.getDataRemocao());
		
		/* Dados basicos */ 		
		usuarioCollection.setEmail(usuario.getEmail());
		usuarioCollection.setSenha(usuario.getSenha());
		usuarioCollection.setNome(usuario.getNome());
		usuarioCollection.setDataUltimoAcesso(usuario.getDataUltimoAcesso());
	
		
		return usuarioCollection;		
	}
	
	/**
	 * Converte um UsuarioCollection em um Usuario.
	 * @param usuarioCollection - documento a ser convertido.
	 * @return Usuario - retorna um Usuario carregado.
	 */
	public Usuario converte (final UsuarioCollection usuarioCollection){
		
		final Usuario usuario = new Usuario();	
		
		usuario.setId(usuarioCollection.getId());
		usuario.setStatus(usuarioCollection.getStatus());
		usuario.setDataCriacao(usuarioCollection.getDataCriacao());
		usuario.setDataRemocao(usuarioCollection.getDataRemocao());
		
		/* Dados basicos */ 
		
		usuario.setEmail(usuarioCollection.getEmail());
		usuario.setSenha(usuarioCollection.getSenha());
		usuario.setNome(usuarioCollection.getNome());
		usuario.setDataUltimoAcesso(usuarioCollection.getDataUltimoAcesso());
	
		
		return usuario;
	}
	
	/**
	 * Converte uma lista de UsuarioCollection em uma lista de Usuario.
	 * @param listaUsuarioCollection - lista de objetos a ser convertida.
	 * @return List<Usuario> - uma lista de objetos Usuario convertida.
	 */
	public List<Usuario> converte(List<UsuarioCollection> listaUsuarioCollection){
		
		final List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for(UsuarioCollection usuario : listaUsuarioCollection){
			listaUsuarios.add(converte(usuario));
		}
		
		return listaUsuarios;		
	}
}
