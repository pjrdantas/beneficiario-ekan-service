package br.com.ekan.service;

import java.sql.SQLException;
import java.util.List;

import br.com.ekan.dto.BeneficiarioDto;

public interface BeneficiarioService {
	
	void createBeneficiario(BeneficiarioDto beneficiarioDto)   throws SQLException; 
	List<BeneficiarioDto> findAllBeneficiario()   throws SQLException; 
	
	void updateBeneficiario(BeneficiarioDto beneficiarioDto)   throws SQLException;	
	void deleteBeneficiario(Long id)   throws SQLException;
	
	

}
