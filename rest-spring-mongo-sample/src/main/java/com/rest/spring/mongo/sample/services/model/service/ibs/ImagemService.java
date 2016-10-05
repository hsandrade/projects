package com.rest.spring.mongo.sample.services.model.service.ibs;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.ImagemCollection;
import com.rest.spring.mongo.sample.services.model.data.nosql.respository.ImagemRepository;
import com.rest.spring.mongo.sample.services.model.service.converter.ImagemConverter;
import com.rest.spring.mongo.sample.services.model.service.domain.Imagem;

/**
 * 
 * Classe que disponbiliza os servicos de negocio
 * internos de Image.   
 * 
 * Essa classe tem como atividade fim disponibilizar
 * uma servicos basicos envolvendo a Imagem.
 * 
 * 
 *  @category Classe de Servicos Basicos.
 *
 */
@Service
@Scope(value="prototype")
public class ImagemService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2677928142799794246L;
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	@Autowired
	private ImagemConverter imagemConverter;
	
	/**
	 * Inserire uma nova imagem.
	 * @param imagem - nova imagem a ser inserida.
	 */
	public void nova(Imagem imagem) {
		
		ImagemCollection imagemCollection = imagemConverter.converte(imagem, true);
		imagemRepository.save(imagemCollection);
		imagem.setId(imagemCollection.getId());
	}
	/**
	 * Recupera uma imagem por seu identificador.
	 * @param identificador - identificador utilizado na localizacao da imagem.
	 * @return Imagem - retorna a imagem localizada. 
	 */
	public Imagem recuperaImagemPorIdentificador(final Long identificador){
		return imagemConverter.converte(imagemRepository.findOne(identificador));
	}
	
}
