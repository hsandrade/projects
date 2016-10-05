package com.rest.spring.mongo.sample.common.exception;

import java.io.Serializable;

/**
 * 
 * Classe que representa violacoes no acesso a camada de servicos.
 * 
 */
public class ServiceException extends BaseException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5891475340979672744L;

	/**
	 * Construtor - Base.
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Construtor - Configura a mensagem explicativa sobre a excecao.
	 * @param message - Mensagem da excecao.
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Construtor - Configura a mensagem explicativa sobre a excecao e sua causa.
	 * @param message - Configura a mensagem a ser notificada.
	 * @param cause - Causa da excecao.
	 *            
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor - Configura a causa
	 * @param cause - Causa da excecao.
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
