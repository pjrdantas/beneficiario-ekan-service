package br.com.ekan.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.config.CreationException;
import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.repository.DocumentoRepository;
import br.com.ekan.service.DocumentoService;

@Service
public class DocumentoServiceImpl implements DocumentoService {
	
	@Autowired
	private DocumentoRepository documentoRepository;

	@Override
	public List<DocumentoDto> findDocumentoByIdBeneficiario(Long id) throws SQLException {
		try {
            return documentoRepository.findDocumentoByIdBeneficiario(id);
        } catch (SQLException e) {
        	throw new CreationException("Erro ao listar o documentos", e.getCause());
        }
	}

	@Override
	public void deleteDocumento(Long id) throws SQLException {
		try {
			documentoRepository.deleteDocumento(id);
		} catch (SQLException e) {
			throw new CreationException("Erro ao excluir o documento", e.getCause());
		}
	}

}
