package com.rest.spring.mongo.sample.services.model.data.nosql.document;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * Classe que define a estrutura de uma colecao de Usuarios.  
 * As infomacoes sobre um determinado Usuario
 * estao distribuidos neste documento.
 * 
 * Essa classe tem como atividade fim a persitencia
 * NoSQL.
 * 
 *  @category Classe de Persistencia NoSQL.
 *
 */
@Document(collection="usuarios")
public class UsuarioCollection extends BaseDocument<Long> implements
Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3504540307299657437L;

	/*
	 * Email do Usuario utilizado na autenticacao.
	 */
	private String email;
	
	/*
	 * Senha do Usuario utilizada na autenticacao. 
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((dataUltimoAcesso == null) ? 0 : dataUltimoAcesso.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioCollection other = (UsuarioCollection) obj;
		if (dataUltimoAcesso == null) {
			if (other.dataUltimoAcesso != null)
				return false;
		} else if (!dataUltimoAcesso.equals(other.dataUltimoAcesso))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{email:" + email + "; nome : "+ nome  + ";}"; 
	}
}
