package com.rest.spring.mongo.sample.services.model.service.domain;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe que define a estrutura de dominio  de Usuario.
 * 
 *  @category Classe de Dominio para atender o Servicos Internos.
 */
@XmlRootElement
public class Usuario extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7591076611852466755L;

	
	/*
	 * Email do Usuario.
	 */
	private String email;
	/*
	 * Senha criptografada SHA1 do usuario,
	 * caso o mesmo nao acesse o sistema por integracao
	 * de redes sociais.
	 */
	private String senha;
	/*
	 * Nome do usuario utilizado no sistema.
	 */
	private String nome;
	/*
	 * Data do ultimo acesso do usuario ao sistema.
	 */
	private Date dataUltimoAcesso;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}
	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}
	

}
