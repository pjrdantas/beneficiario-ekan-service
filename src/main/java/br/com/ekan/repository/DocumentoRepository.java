package br.com.ekan.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.ekan.dto.DocumentoDto;

public interface DocumentoRepository {
	
	void createDocumento(DocumentoDto documentoDto)   throws SQLException; 
	List<DocumentoDto> findDocumentoByIdBeneficiario(Long id) throws SQLException;
	void deleteDocumento(Long id)   throws SQLException;
	DocumentoDto findDocumentoById(Long id) throws SQLException;

}
