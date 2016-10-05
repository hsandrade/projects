/**
 * 
 */
package com.rest.spring.mongo.sample.common.exception;

import java.io.Serializable;

/**
 * 
 * Classe que representa violacoes no acesso ao controlador.
 * 
 */
public class ControllerException extends BaseException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7689836938828068948L;

	/**
	 * Construtor - Base.
	 */
	public ControllerException() {
		super();
	}

	/**
	 * Construtor - Configura a mensagem explicativa sobre a excecao
	 * @param message - Mensagem da excecao.
	 */
	public ControllerException(String message) {
		super(message);
	}

	/**
	 * Construtor - Configura a mensagem explicativa sobre a excecao e sua causa.
	 * @param message - Configura a mensagem a ser notificada.
	 * @param cause - Causa da excecao.
	 */
	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor - Configura a causa.
	 * @param cause - Causa da excecao.
	 */
	public ControllerException(Throwable cause) {
		super(cause);
	}
}
