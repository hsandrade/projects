package com.rest.spring.mongo.sample.services.model.aop.logger;


import java.io.Serializable;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rest.spring.mongo.sample.common.exception.ControllerException;
import com.rest.spring.mongo.sample.common.exception.ServiceException;
/**
 * 
 * 
 * Classe responsavel por interceptar , tratar e registrar informacoes
 * referentes a classes e metodos do Modelo.
 * 
 *  
 *  @category Classe de controle de falhas.
 *
 */
@Aspect
public class ExceptionModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6132424483935385775L;
	
	public ExceptionModel(){};
	
	@Pointcut("within(com.rest.spring.mongo.sample.services.model..*)")
	public void controllerException(){};
	
	/**
	 * Interceptador com o objetivo de tratar excecoes na execucao 
	 * de metodos da camada de controle. 
	 * @param jointPoint - JoinPoint fornecido atraves do AspectJ.
	 * @return Object - Retorna proceed no caso de sucesso da execucao do metodo.
	 * @throws Throwable - Em caso de falha uma Throwable sera lancada. 
	 */
	@Around("SeviceException()")
    public Object executionControllerMethod(ProceedingJoinPoint jointPoint) throws Throwable {
		
		Logger log = LoggerFactory.getLogger(jointPoint.getSignature().getDeclaringType());
		String methodName = jointPoint.getSignature().getName();
		String className = jointPoint.getSignature().getDeclaringType().toString();
		long time = new Date().getTime();
		
		try{
			
			 return jointPoint.proceed();
			 
		}catch (ControllerException sexc){	 
			
			StringBuffer stackTrace = recuperaInformacoesDaFalha(sexc);
			log.error("[Server - "+ time +"] - Ocorreu uma falha inexeperada na camada do barramento de servicos rest.\n Na classe " + 
			className + " no metodo " + methodName + ". Detalhes da falha: "
					.concat(stackTrace.toString()));
			return null;

			 
		}catch (ServiceException sexc){

			StringBuffer stackTrace = recuperaInformacoesDaFalha(sexc);
			log.error("[Server - "+ time +"] - Ocorreu uma falha inexeperada na camada interna de servicos de negocio.\n Na classe " + 
					className + " no metodo " + methodName + ". Detalhes da falha: "
							.concat(stackTrace.toString()));

			return null;
			
		}catch(Exception exp){
			
				StringBuffer stackTrace = recuperaInformacoesDaFalha(exp);
				log.error("[Server - "+ time +"] - Ocorreu uma falha inexeperada.\n Na classe " + 
						className + " no metodo " + methodName + ". Detalhes da falha: "
								.concat(stackTrace.toString()));

				return null;
		} 
						
	}
	/**
	 * Metodo privado que tem como finalidade recuperar infomacoes
	 * da falha e retornar organizada em um StringBuffer.
	 * @param exp - falha.
	 * @return StringBuffer - retorna um StringBuffer com informacoes da 
	 * falha em um formato organizado.
	 */
	private StringBuffer recuperaInformacoesDaFalha(Exception exp) {
		StringBuffer stackTrace = new StringBuffer("\n");
		
		for (int i = 0; i < exp.getStackTrace().length; i++){
			stackTrace.append(exp.getStackTrace()[i].toString()).append("\n");
		}
		return stackTrace;
	}

}
