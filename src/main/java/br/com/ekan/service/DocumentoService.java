package br.com.ekan.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ekan.dto.DocumentoDto;

public interface DocumentoService {
	
	List<DocumentoDto> findDocumentoByIdBeneficiario(Long id) throws SQLException;

}
