package br.com.ekan.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.config.CreationException;
import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.repository.BeneficiarioRepository;
import br.com.ekan.repository.DocumentoRepository;
import br.com.ekan.service.BeneficiarioService;


@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Override
	public void createBeneficiario(BeneficiarioDto beneficiarioDto) throws SQLException {
        try {
        		
                beneficiarioRepository.createBeneficiario(beneficiarioDto);
                BeneficiarioDto foundBeneficiario = beneficiarioRepository.findBeneficiarioByName(beneficiarioDto.getBeneficiarioNome());
                Long idBeneficiario = foundBeneficiario.getId();
                List<DocumentoDto> documentos = beneficiarioDto.getDocumentos();
                if (documentos != null && !documentos.isEmpty()) {
                    for (DocumentoDto documento : documentos) {
                        documento.setBeneficiarioId(idBeneficiario);
                        documentoRepository.createDocumento(documento);
                    }
                }                
        } catch (SQLException e) {
            throw new CreationException("Erro desconhecido criar o beneficiario", e.getCause());
        }		
	}

	
	@Override
	public List<BeneficiarioDto> findAllBeneficiario() throws SQLException {
        try {
            return beneficiarioRepository.findAllBeneficiario();
        } catch (SQLException e) {
        	throw new CreationException("Erro ao listar o beneficiario", e.getCause());
        }

	}	
	
	
	@Override
	public void updateBeneficiario(BeneficiarioDto beneficiarioDto) throws SQLException {
        try {
        	beneficiarioRepository.updateBeneficiario(beneficiarioDto);
        } catch (SQLException e) {                   
            throw new CreationException("Erro ao atualizar o beneficiario", e.getCause());
        }		
	}
	

	@Override
	public void deleteBeneficiario(Long id) throws SQLException {
        try {
        	beneficiarioRepository.deleteBeneficiario(id);
        } catch (SQLException e) {              
            throw new CreationException("Erro ao excluir o beneficiario", e.getCause());
        }				
	}


	

}
