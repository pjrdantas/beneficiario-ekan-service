package br.com.ekan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.service.DocumentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value = "service")
@RequestMapping("/service/documento")
public class DocumentoController {
	
	private static final Logger _logger = LoggerFactory.getLogger(DocumentoController.class);
	
	@Autowired
	private DocumentoService documentoService;
	
	
	@ApiOperation(value = "CONSULTAR LISTA DE DOCUMENTOS DE UM PERFIL")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/findByIdBeneficiario/{idBeneficiario}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<DocumentoDto>> findIdBeneficiario(@PathVariable("idBeneficiario") Long id) {
		
		try {
			List<DocumentoDto> documento = documentoService.findDocumentoByIdBeneficiario(id);
			if (!documento.isEmpty()) {
				_logger.info("Lista de documentos de um beneficiario obtida com sucesso!");
				return new ResponseEntity<>(documento, HttpStatus.OK);
			} else {
				_logger.warn("Lista de documentos de um beneficiario está vazia!");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			_logger.error("Erro ao listar os documentos do beneficiario: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}	
	
}
