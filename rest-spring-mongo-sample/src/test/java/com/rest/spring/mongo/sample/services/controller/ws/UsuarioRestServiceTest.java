package com.rest.spring.mongo.sample.services.controller.ws;


import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.rest.spring.mongo.sample.services.init.ApplicationConfig;
import com.rest.spring.mongo.sample.services.model.service.domain.Usuario;
import com.rest.spring.mongo.sample.services.model.service.ibs.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class UsuarioRestServiceTest {

	private Logger log = LoggerFactory.getLogger(UsuarioRestServiceTest.class);

	@Autowired
	public UsuarioRestService usuarioRestService;
	@Autowired
	public UsuarioService usuarioService; 
	
	@Test	
	public void novoUsuario(){
		
		log.info("Inserindo novo usuario");
		
		final Usuario usuario = inserirUsuario();
		
		log.info("Usuario inserido com sucesso! id:" + usuario.getId());
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void atualizaUsuario(){
		
		Usuario usuario = inserirUsuario();
		
		log.info("Atualizando o usuario de id:" + usuario.getId() + " e nome: " + usuario.getNome() +".");
		
		usuario.setNome("Usuario modificado" + new Date().getTime());
		
		@SuppressWarnings("unchecked")
		ResponseEntity<Usuario> response = (ResponseEntity<Usuario>)usuarioRestService.atualizaUsuario(usuario);		
		
		if (response.getStatusCode() == HttpStatus.OK){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);	
		}				
	}
	
	@Test
	public void recuperaUsuarioPeloIdentificador(){
		
		final Usuario usuario = inserirUsuario();
		
		log.info("Recuperando um usuario existente de id: " + usuario.getId() + ".");
		
		ResponseEntity<?> response = usuarioRestService.recuperaUsuarioPorId(usuario.getId());
		
		if (response.getStatusCode() == HttpStatus.OK){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);	
		}	
	}
	
	@Test
	public void listaTodosUsuario(){
		
		for (int i = 0 ; i < 10 ; i++) inserirUsuario();
			
		log.info("Listando os 10 primeiros usuarios...");
			
		ResponseEntity<?> response = usuarioRestService.listaTodos(0, 10);
		
		if (response.getStatusCode() == HttpStatus.OK){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}		
	}
	
	@Test
	public void removerUsuarioPorId(){	
		
		Usuario usuario = inserirUsuario();
		
		log.info("Removendo o usuario de id : " + usuario.getId() + ".");
		
		ResponseEntity<?> response = usuarioRestService.removePorIdentificador(usuario.getId());	
		
		if (response.getStatusCode() == HttpStatus.OK){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);	
		}	
	}
	
	@Test
	public void recuperaUsuarioPorNome(){
		log.info("Recuperando usuario pelo nome: Usuario.");
		
		ResponseEntity<?> response = usuarioRestService.recuperaPorNome("Usuario");
		
		if (response.getStatusCode() == HttpStatus.OK){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);	
		}
	}
	

	private Usuario inserirUsuario(){
		
		final Usuario usuario = new Usuario();
		
		usuario.setEmail("usuario@usuario.com.br");
		usuario.setSenha("123456");
		usuario.setNome("Usuario");
		
		usuarioRestService.novo(usuario);
		
		return usuario;	
	}

}