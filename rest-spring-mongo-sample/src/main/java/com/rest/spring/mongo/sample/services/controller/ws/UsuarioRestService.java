package com.rest.spring.mongo.sample.services.controller.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring.mongo.sample.services.model.service.domain.Usuario;
import com.rest.spring.mongo.sample.services.model.service.ibs.UsuarioService;

/**
 * 
 * Classe integrante do barramento de servicos WebService-Rest.   
 * 
 *  @category Classe WebService-Rest.
 */
@RestController
public class UsuarioRestService extends BaseRestController{
	
	@Autowired
	private UsuarioService usuarioService;	
	
	private Logger log = LoggerFactory.getLogger(UsuarioRestService.class);
	
	/**
	 * Insere um novo usuario.
	 * @param usuario - usuario a ser inserido.
	 * @return ResponseEntity<?> - retorna o usuario inserido. 
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST , headers="Accept=application/json")
	public ResponseEntity<?> novo(@RequestBody Usuario usuario){
		
		try{
			usuarioService.novo(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK) ;
		} catch (Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_POST, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}
	
	/**
	 * Atualiza um usuario existente.
	 * @param usuario - usuario a ser atualizado.
	 * @return ResponseEntity<?> - retorna o usuario atualizado. 
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT , headers="Accept=application/json")
	public ResponseEntity<?> atualizaUsuario(@RequestBody Usuario usuario){
		try{			
			usuarioService.atualizar(usuario);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK) ;
		} catch (Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_POST, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}	
	
	
	/**
	 * Recupera utilizando o token de seguranca oAuth2 um objeto do tipo Usuario pelo seu identificador.
	 * @param id - identificador do Usuario.
	 * @return  ResponseEntity<?> - retorna um ResponseEntity com informacoes do Usuario.
	 */
	@RequestMapping(value = "/usuario/oAuth2/{id}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> recuperaOauth2UsuarioPorId(@PathVariable("id") Long id){
		try{
			Usuario usuario = usuarioService.recuperaPorIdentificador(id);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}catch(Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_GET, HttpStatus.INTERNAL_SERVER_ERROR) ;			
		}		
	}
	

	/**
	 * Recupera um objeto do tipo Usuario pelo seu identificador.
	 * @param id - identificador do Usuario.
	 * @return  ResponseEntity<?> - retorna um ResponseEntity com informacoes do Usuario.
	 */
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> recuperaUsuarioPorId(@PathVariable("id") Long id){
		try{
			Usuario usuario = usuarioService.recuperaPorIdentificador(id);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}catch(Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_GET, HttpStatus.INTERNAL_SERVER_ERROR) ;			
		}		
	}
	
	/**
	 * Recupera todos os usuarios e prove um mecanismo de paginacao.
	 * @param pagina - pagina corrente dentro do total de usuarios.
	 * @param total - total de usuarios localizados
     * @return ResponseEntity<?> - retorna uma lista contendo um ou mais usuarios localizados.
	 */
	@RequestMapping(value = "/usuario/todos/{pagina}/{total}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> listaTodos(@PathVariable("pagina") final int pagina, @PathVariable("total") final int total){
		try{
			return new ResponseEntity<List<Usuario>>(usuarioService.listaTodos(pagina, total) , HttpStatus.OK);
		}catch(Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_GET , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Recupera um ou mais usuarios por seu nome.
	 * @param nome - nome do(s) usuario(s) a serem localizados.
	 * @return ResponseEntity<?> - retorna uma lista contendo um ou mais usuarios localizados.
	 */
	@RequestMapping(value = "/usuario/nome/{nome}", method = RequestMethod.GET , headers="Accept=application/json")
	public ResponseEntity<?> recuperaPorNome(@PathVariable("nome") final String nome){
		try{
			return new ResponseEntity<List<Usuario>>(usuarioService.recuperaUsuariosPorNome(nome) , HttpStatus.OK);
		}catch(Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_GET , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Remove um usuario por seu identificador.
	 * @param identificador - id utilizado na busca do usuario a ser
	 * removido.
	 */
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removePorIdentificador(@PathVariable("id") Long id) {
		
		try{
			usuarioService.removePorIdentificador(id);
			return new ResponseEntity<String>(MSG_SUCCESS, HttpStatus.OK);
		}catch (Exception e){
			log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_DELETE, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
}
