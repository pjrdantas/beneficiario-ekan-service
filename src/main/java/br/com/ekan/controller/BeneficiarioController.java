package br.com.ekan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.service.BeneficiarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value = "service")
@RequestMapping("/service/beneficiario")
public class BeneficiarioController {
    
    private static final Logger _logger = LoggerFactory.getLogger(BeneficiarioController.class);
    
    @Autowired
	private BeneficiarioService beneficiarioService;

 

    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "INCLUIR BENEFICIARIO")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 201, message = "Criado."),
            @ApiResponse(code = 400, message = "Requisição Invalida."),
            @ApiResponse(code = 401, message = "Não Autorizado"),
            @ApiResponse(code = 403, message = "Acesso Proibido"),
            @ApiResponse(code = 404, message = "Não Localizado"),
            @ApiResponse(code = 409, message = "Erro de integridade do registro."),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção.")
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> salvarBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) {
        try {            
            this.beneficiarioService.createBeneficiario(beneficiarioDto);
            if (beneficiarioDto != null) {
                _logger.info("Beneficiario criado com sucesso!");
                return new ResponseEntity<>("Beneficiario e documentos salvos com sucesso", HttpStatus.CREATED);
            } else {
                _logger.error("O registro não pode ser nulo. Por favor, forneça os dados necessários.");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }   
        } catch (DataIntegrityViolationException e) {
            _logger.error("Erro de integridade ao criar o Beneficiario. Verifique se os dados são válidos.", e.getCause());
            return new ResponseEntity<>(HttpStatus.CONFLICT);           
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar beneficiario e documentos", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
	@ApiOperation(value = "CONSULTAR LISTA DE BENEFICIARIOS")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna a lista de regras"),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<BeneficiarioDto>> findAll() {

		try {
			List<BeneficiarioDto> beneficiarioDto = beneficiarioService.findAllBeneficiario();
			if (!beneficiarioDto.isEmpty()) {
				_logger.info("Lista de beneficiario obtida com sucesso!");
				return new ResponseEntity<>(beneficiarioDto, HttpStatus.OK);
			} else {
				_logger.warn("Lista de beneficiario está vazia!");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			_logger.error("Erro ao listar os beneficiarios: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@ApiOperation(value = "ATUALIZAR BENEFICIARIOS")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 204, message = "Requisição foi bem-sucedida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Void> update(@RequestBody BeneficiarioDto beneficiarioDto) {

		try {
			this.beneficiarioService.updateBeneficiario(beneficiarioDto);
			_logger.info("Beneficiario atualizado com sucesso!");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			_logger.error("Erro de integridade ao atualizar o beneficiario. Verifique se os dados são válidos.",
					e.getCause());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			_logger.error("Erro ao atualizar o beneficiario: ", e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	@ApiOperation(value = "EXCLUIR A BENEFICIARIO POR ID")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "ok"),
			@ApiResponse(code = 204, message = "Requisição foi bem-sucedida."),
			@ApiResponse(code = 401, message = "Não Autorizado"),
			@ApiResponse(code = 403, message = "Acesso Proibido"),
			@ApiResponse(code = 404, message = "Não Localizado"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/delete/{idBeneficiario}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable("idBeneficiario") Long idBeneficiario) {

		try {
			beneficiarioService.deleteBeneficiario(idBeneficiario);
			_logger.info("Beneficiario excluido com sucesso!");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			_logger.warn("Nenhuma Beneficiario foi encontrado para excluir com o ID: {}", idBeneficiario);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			_logger.error("Erro ao excluir o beneficiario por ID: {}", idBeneficiario, e.getCause());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
	
	
	
	
	
}
