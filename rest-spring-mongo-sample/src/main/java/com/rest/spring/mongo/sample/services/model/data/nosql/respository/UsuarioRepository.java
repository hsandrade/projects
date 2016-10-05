package com.rest.spring.mongo.sample.services.model.data.nosql.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.UsuarioCollection;

/**
 * 
 * Classe que define as operacoes em uma colecao de Usuario.  
 * 
 * Essa classe tem como atividade fim a  realizar operacoes
 * em um base de dados NoSQL.
 * 
 * 
 *  @category Classe de operacoes NoSQL.
 *
 */
@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioCollection, Long>{
	
	  @Query("{ nome: ?0 }")
	  List<UsuarioCollection> findByNome(String descricao);

}
