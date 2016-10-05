package com.rest.spring.mongo.sample.services.model.data.nosql.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.ImagemCollection;

/**
 * 
 * Classe que define as operacoes em uma colecao de Imagem.  
 * 
 * Essa classe tem como atividade fim a  realizar operacoes
 * em um base de dados NoSQL.
 * 
 * 
 *  @category Classe de operacoes NoSQL.
 *
 */
@Repository
public interface ImagemRepository extends MongoRepository<ImagemCollection, Long>{

}
