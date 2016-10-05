package com.rest.spring.mongo.sample.services.model.data.nosql.document;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * 
 * Classe que define a estrutura de uma colecao de Imagem.  
 * As infomacoes sobre uma determinada imagem
 * estao distribuidas neste documento.
 * 
 * Essa classe tem como atividade fim a persitencia
 * NoSQL.
 * 
 *  @category Classe de Persistencia NoSQL.
 *
 */
@Document(collection="imagens")
public class ImagemCollection extends BaseDocument<Long> implements 
Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5977899552462417907L;
	/*
	 * Nome do arquivo.
	 */
	private String fileName;
	/*
	 * Tipo do arquivo
	 * de imagem.
	 */
	private String contentType;
	/*
	 * Data que o
	 * arquivo foi recebido pelo sistema.
	 */
	private Date uploadDate;
	/*
	 * Tamanho do arquivo.
	 */
	private Long length;
	
	/*
	 * Stream do imagem
	 */
	private byte [] stream;
	/*
	 * Informacoes adicionais
	 * do arquivo carregado.
	 */
	private String metaData;
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	/**
	 * @return the length
	 */
	public Long getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Long length) {
		this.length = length;
	}
	/**
	 * @return the metaData
	 */
	public String getMetaData() {
		return metaData;
	}
	/**
	 * @param metaData the metaData to set
	 */
	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public byte[] getStream() {
		return stream;
	}
	public void setStream(byte[] stream) {
		this.stream = stream;
	}

}
