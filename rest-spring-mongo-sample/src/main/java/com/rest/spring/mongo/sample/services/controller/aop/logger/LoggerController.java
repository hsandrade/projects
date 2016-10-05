package com.rest.spring.mongo.sample.services.controller.aop.logger;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe responsavel por interceptar e registrar informacoes
 * referentes a classes e metodos do controlador com a finalidade
 * de logar as acoes do Usuario.
 * 
 * @category Classe de controle de acessos.
 */
@Aspect
public class LoggerController {
	
	public LoggerController(){}
	
	@Pointcut("within(com.rest.spring.mongo.sample.services.controller..*)")
	public void loggerControllerPointCut(){};
	
	/**
	 * Interceptador com o objetivo de logar as acoes do Usuario. 
	 * @param jointPoint - JoinPoint fornecido atraves do AspectJ.
	 * @return Object - Retorna proceed no caso de sucesso da execucao do metodo.
	 * @throws Throwable - Em caso de falha uma Throwable sera lancada. 
	 */
	@Around("loggerControllerPointCut()")
    public Object executionControllerMethod(ProceedingJoinPoint jointPoint) throws Throwable {
		
		Logger log = LoggerFactory.getLogger(jointPoint.getSignature().getDeclaringType());
		
    	long startTimeMillis = System.currentTimeMillis();
    	String methodName = jointPoint.getSignature().getName();
    	
    	StringBuffer buffer = null;
    	
    	if (log.isDebugEnabled()) {
    		
    		buffer = new StringBuffer("Iniciando: [");
    		buffer.append(methodName).append("] identificador: [").append(startTimeMillis).append("]");
    		log.info(buffer.toString());
    	}
    	
    	try {
    		return jointPoint.proceed();
    		
    	} finally {
    		
    		long totalTimeMillis = System.currentTimeMillis() - startTimeMillis;
    		
    		if (log.isDebugEnabled()) {
    			
    			buffer = new StringBuffer("Finalizando: [");
	    		buffer.append(methodName).append("] identificador: [").append(startTimeMillis);
	    		buffer.append("] tempo total: [").append(totalTimeMillis).append(" ms]");
	    		log.info(buffer.toString());
	    			
    		}
    	}
    }
}
