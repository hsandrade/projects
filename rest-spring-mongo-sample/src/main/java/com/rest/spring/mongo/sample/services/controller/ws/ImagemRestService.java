package com.rest.spring.mongo.sample.services.controller.ws;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rest.spring.mongo.sample.services.model.service.domain.Imagem;
import com.rest.spring.mongo.sample.services.model.service.ibs.ImagemService;

/**
 * 
 * Classe integrante do barramento de servicos WebService-Rest.   
 * 
 *  @category Classe WebService-Rest.
 */
@RestController
public class ImagemRestService extends BaseRestController{
	
	@Autowired
	private ImagemService imagemService;
	
	private Logger log = LoggerFactory.getLogger(ImagemRestService.class);
	
	/**
	 * Insere uma nova imagem.
	 * @param file - arquivo contendo a nova imagem.
	 * @return ResponseEntity<?> - retorna a imagem inserida. 
	 */
	@RequestMapping(value = "/imagem/upload", headers="content-type=multipart/*" , method = RequestMethod.POST, consumes="multipart/form-data", produces="application/json")
	public ResponseEntity<?> novaImagem(@RequestParam("file") MultipartFile file){
		
        if (!file.isEmpty()) {
            try {
            	
                byte[] bytes = file.getBytes();
                Imagem imagem  = new Imagem();
                imagem.setContentType(file.getContentType());
                imagem.setStream(bytes);
                imagem.setFileName(file.getOriginalFilename());
                imagem.setLength(file.getSize());
                
                imagemService.nova(imagem);
                
                return new ResponseEntity<String>(MSG_SUCCESS, HttpStatus.OK) ;
            } catch (Exception e) {
            	log.error(LOG_INTERNAL_SERVER_ERROR.concat(e.toString()));
    			return new ResponseEntity<String>(MSG_INTERNAL_SERVER_ERROR_POST, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<String>(MSG_PARAM_NOT_FOUND, HttpStatus.OK) ;
        }
	
	}
	
	/**
	 * Recupera uma imagem existente.
	 * @param id - identificador da imagem.
	 * @return byte [] - retorna a imagem solicitada.
	 * @throws IOException - Levanta em caso de falha.
	 */
	@ResponseBody
	@RequestMapping(value = "/imagem/stream/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] testphoto(@PathVariable("id") final Long id) throws IOException {
		
		  try {
			  final Imagem imagem = imagemService.recuperaImagemPorIdentificador(id); 
			  return imagem.getStream();
			  
		  } catch (Exception e) {
         	InputStream imagemDefault = this.getClass().getClassLoader().getResourceAsStream("img/image-not-found.jpg");
          	return IOUtils.toByteArray(imagemDefault);
          	
          }
		
	}
	

}
