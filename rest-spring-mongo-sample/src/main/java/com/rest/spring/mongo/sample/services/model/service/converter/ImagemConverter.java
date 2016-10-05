package com.rest.spring.mongo.sample.services.model.service.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rest.spring.mongo.sample.services.model.data.nosql.document.ImagemCollection;
import com.rest.spring.mongo.sample.services.model.data.nosql.respository.ImagemRepository;
import com.rest.spring.mongo.sample.services.model.service.domain.Imagem;
import com.rest.spring.mongo.sample.services.model.service.ibs.CounterService;

/**
 * 
 * Classse responsavel em realizar conversoes com 
 * o dominio Imagem.
 * 
 * @category Conversores de Dominios.
 *
 */
@Component
@Scope(value="prototype")
public class ImagemConverter {
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	/**
	 * Converte uma Imagem Dominio em uma Imagem Collection.
	 * @return ImagemCollection - retorna umao objeto de persistencia.
	 */
	public ImagemCollection converte(Imagem imagem,
			boolean novaImagem) {
		
		ImagemCollection imagemCollection = new ImagemCollection();
		
		//Id
		if(novaImagem){
			imagemCollection.setId(counterService.getNextSequence("imangens"));
			imagemCollection.setDataCriacao(new Date());
			imagemCollection.setStatus("Ativo");
		}else {
			imagemCollection.setId(imagem.getId());
			imagemCollection.setStatus(imagem.getStatus());
			imagemCollection.setDataCriacao(imagem.getDataCriacao());
		}
		
		imagemCollection.setFileName(imagem.getFileName());
		imagemCollection.setLength(imagem.getLength());
		imagemCollection.setMetaData(imagem.getMetaData());
		imagemCollection.setUploadDate(imagem.getUploadDate());
		imagemCollection.setContentType(imagem.getContentType());
		imagemCollection.setStream(imagem.getStream());
		
		imagemCollection.setDataRemocao(imagem.getDataRemocao());
		
		return imagemCollection;
	}
	
	/**
	 * Convete uma Colecao de Dominio.
	 * @param imagemCollection - colecao a ser convertida.
	 * @return Imagem - retorna um objeto de dominio de Imagem.
	 */
	public Imagem converte(final ImagemCollection collection){
		
		Imagem imagem = new Imagem();
		
		imagem.setFileName(collection.getFileName());
		imagem.setLength(collection.getLength());
		imagem.setMetaData(collection.getMetaData());
		imagem.setUploadDate(collection.getUploadDate());
		imagem.setContentType(collection.getContentType());
		imagem.setStream(collection.getStream());
		
		return imagem;
	}
	
	/**
	 * Converte uma lista de objetos persistidos de Imagem para
	 * uma lista de Dominios de Imagem.
	 * @param collections - lista de objetos persistidos.
	 * @return List<Imagem> - lista de dominio.
	 */
	public List<Imagem> converte(final List<ImagemCollection> collections){
		
	    List<Imagem> lista = new ArrayList<Imagem>();
		
		for(ImagemCollection col : collections){
			lista.add(converte(col));
		}
		
		return lista;
		
	}
	
	

}
