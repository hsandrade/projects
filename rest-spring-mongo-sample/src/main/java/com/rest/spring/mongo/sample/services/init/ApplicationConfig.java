package com.rest.spring.mongo.sample.services.init;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.MongoClient;
import com.rest.spring.mongo.sample.services.controller.aop.logger.LoggerController;
import com.rest.spring.mongo.sample.services.model.aop.logger.LoggerModel;
/**
 * Classse responsavel pelas configuracoes do ambiente Spring.
 * 
 * @category Configuracao do recursos do sistema.
 *
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.rest.spring.mongo.sample")
@PropertySource("classpath:application.properties")
@ImportResource("/WEB-INF/spring-security.xml")
@EnableMongoRepositories(basePackages="com.rest.spring.mongo.sample.services.model.data.nosql")
@EnableAspectJAutoProxy
public class ApplicationConfig {

	//Injeta o recurso responsavel em prover informacoes do ambiente.
	@Resource
	private Environment env;
	
	/**
	 * Meotodo responsavel por criar uma instancia da Fabrica MongoDbFactory.
	 * @return MongoDbFactory - retorna um objeto MongoDBFactory.
	 * @throws Exception - levanta uam Exception em caso de falha na 
	 * criacao do objeto de retorno.
	 */
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
		
		MongoClient mongoClient = new MongoClient("localhost",27017);
    	return new SimpleMongoDbFactory(mongoClient,"sample_mongo");
		
    }
	
	
	
	/**
	 * Metodo responsavel em configurar o MongoTemplate.
	 * @return MongoTemplate - retorna uma instancia do tipo de
	 * objeto Mongo Template.
	 * @throws Exception - levanta uam Exception em caso de falha na 
	 * criacao do objeto de retorno.
	 */
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
	
	/**
	 * Metodo responsavel em habilitar o upload Multipart.
	 * @return CommonsMultipartResolver - retorna um Commons Multipart Resolver.
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}
	/**
	 * Metodo responsavel pela configuracao do recurso de Resource Bundle.
	 * @return ResourceBundleMessageSource - retorna uma instancia do Resource
	 * Bundle.
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename(env.getRequiredProperty("message.source.basename"));
		source.setUseCodeAsDefaultMessage(true);
		
		return source;
	}
	/**
	 * Metodo responsavel pela geracao da instancia do LogController Aop.
	 * @return LoggerController - retorna uma instancia do LogController. 
	 */
	@Bean
	public LoggerController loggerControllerAop(){
		return new LoggerController();
	}
	
	/**
	 * Metodo responsavel pela geracao da instancia do LogModel Aop.
	 * @return LoggerModel - retorna uma instancia do LogModel. 
	 */
	@Bean
	public LoggerModel loggerModelAop(){
		return new LoggerModel();
	}


}
