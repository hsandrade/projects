package com.rest.spring.mongo.sample.services.controller.ws;

/**
 * 
 * Classe base de servicos WebService-Rest.   
 * 
 *  @category Classe Base WebService-Rest.
 */
public class BaseRestController {
	
	protected final String MSG_INTERNAL_SERVER_ERROR_GET = "Ocorreu um erro ao localizar o recurso solicitado.";
	protected final String MSG_INTERNAL_SERVER_ERROR_PUT = "Ocorreu um erro ao atualizar o recurso solicitado.";
	protected final String MSG_INTERNAL_SERVER_ERROR_DELETE = "Ocorreu um erro ao remover o recurso solicitado.";
	protected final String MSG_INTERNAL_SERVER_ERROR_POST = "Ocorreu um erro ao persistir o recurso solicitado.";
	protected final String MSG_SUCCESS = "Operacao realizada com sucesso.";
	protected final String MSG_PARAM_NOT_FOUND = "Os parametros obrigatorios para a execucao do servico nao foram localizados.";
	protected final String LOG_INTERNAL_SERVER_ERROR = "[Server] - Ocorreu uma falha durante o processamento da requisicao." + 
			"Detalhes da falha: ";
	

}
