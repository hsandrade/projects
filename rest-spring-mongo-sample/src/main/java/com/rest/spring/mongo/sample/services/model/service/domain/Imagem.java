package com.rest.spring.mongo.sample.services.model.service.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe que define a estrutura de dominio  de Imagem.
 * 
 *  @category Classe de Dominio para atender o Servicos Internos.
 */
@XmlRootElement
public class Imagem extends BaseDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6595932940577061359L;

	/*
	 * Nome do arquivo.
	 */
	private String fileName;
	
	/*
	 * Stream da imagem
	 */
	private byte []  stream;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result
				+ ((metaData == null) ? 0 : metaData.hashCode());
		result = prime * result
				+ ((uploadDate == null) ? 0 : uploadDate.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Imagem)) {
			return false;
		}
		Imagem other = (Imagem) obj;
		if (contentType == null) {
			if (other.contentType != null) {
				return false;
			}
		} else if (!contentType.equals(other.contentType)) {
			return false;
		}
		if (fileName == null) {
			if (other.fileName != null) {
				return false;
			}
		} else if (!fileName.equals(other.fileName)) {
			return false;
		}
		if (length == null) {
			if (other.length != null) {
				return false;
			}
		} else if (!length.equals(other.length)) {
			return false;
		}
		if (metaData == null) {
			if (other.metaData != null) {
				return false;
			}
		} else if (!metaData.equals(other.metaData)) {
			return false;
		}
		if (uploadDate == null) {
			if (other.uploadDate != null) {
				return false;
			}
		} else if (!uploadDate.equals(other.uploadDate)) {
			return false;
		}
		return true;
	}
	public byte[] getStream() {
		return stream;
	}
	public void setStream(byte[] stream) {
		this.stream = stream;
	}
	
	

}
