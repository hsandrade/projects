package com.rest.spring.mongo.sample.services.model.service.ibs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.CounterDocument;

@Service
@Scope(value="prototype")
public class CounterService {

  @Autowired 
  private MongoOperations mongo;
  private CounterDocument counter;
   
  /**
   * Recupera a proxima sequence de um documento ou de uma colecao.
   * @param documentOrCollectioName - documento ou colecao onde um novo 
   * identificador sera gerado.
   * @return Long - retorna um novo identificador.
   */
  public Long getNextSequence(String documentOrCollectioName) {
	  
    counter = mongo.findAndModify(new Query(Criteria.where("_id").is(documentOrCollectioName)), 
      new Update().inc("seq", 1),
      FindAndModifyOptions.options().returnNew(true),
      CounterDocument.class);
    
    if (counter == null){
    	counter = new CounterDocument();
    	counter.setId(documentOrCollectioName);
    	counter.setSeq(1L);
    	mongo.insert(counter);
    }
    
      return counter.getSeq();
  }
}
