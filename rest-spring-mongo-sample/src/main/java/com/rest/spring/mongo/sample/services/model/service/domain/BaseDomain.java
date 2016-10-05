package com.rest.spring.mongo.sample.services.model.service.domain;

import java.util.Date;

/**
 * 
 * Classe que define a estrutura obrigatoria
 * de objetos de dominio para atender a camada
 * de servicos.
 * 
 *  @category Classe base de dominio para servicos internos
 *  de negocio.
 *
 */
public class BaseDomain {
	
	/*
	 * Chave de identificacao do objeto
	 */
	private Long id;
	
	/*
	 * Representa a situacao do documento, se
	 * o mesmo esta Em avaliacao / Ativo / Inativo.
	 */
	private String status;
	private Date dataCriacao;
	private Date dataRemocao;
	
	
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
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
