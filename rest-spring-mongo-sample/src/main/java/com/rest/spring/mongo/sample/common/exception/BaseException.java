package com.rest.spring.mongo.sample.common.exception;

import java.io.Serializable;

/**
 * Classe base de excecao do tipo Runtime.
 * 
 */
public abstract class BaseException extends RuntimeException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8152040273209939885L;

	/**
	 * Construtor - Base.
	 * 
	 */
	public BaseException() {
		super();
	}

	/**
	 * Construtor - Configura a mensagem explicativa sobre a excecao.
	 * @param message - Configura a mensagem a ser notificada.
	 */
	public BaseException(String message) {
		super(message);
	}

	/**
	 * Construtor - Configura a mensagem explicativa sobre a excecao e sua causa.
	 * @param message - Configura a mensagem a ser notificada.
	 * @param cause - Causa da excecao.
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Construtor - Configura a causa.
	 * @param cause - Causa da excecao.
	 *            
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}
}
