package com.rest.spring.mongo.sample.services.model.data.nosql.document;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Classe que define a estrutura basica de um Documento NoSQL.
 * @param <Key> - Tipo da chave do identificador do Documento. 
 *
 */
public class BaseDocument<Key>{
	
	@Id private Key id;
	
	/*
	 * Representa a situacao do documento, se
	 * o mesmo esta Em avaliacao / Ativo / Inativo.
	 */
	private String status;
	private Date dataCriacao;
	private Date dataRemocao;

	/**
	 * @return the id
	 */
	public Key getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Key id) {
		this.id = id;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null 
				|| !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		return this.id.
				equals(((BaseDocument<Key>)obj).getId());
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the dataRemocao
	 */
	public Date getDataRemocao() {
		return dataRemocao;
	}

	/**
	 * @param dataRemocao the dataRemocao to set
	 */
	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}
}
