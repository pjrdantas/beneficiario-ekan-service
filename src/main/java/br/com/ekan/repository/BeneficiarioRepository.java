package br.com.ekan.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.ekan.dto.BeneficiarioDto;

public interface BeneficiarioRepository {
	
	
	
	void createBeneficiario(BeneficiarioDto beneficiarioDto)   throws SQLException; 
	BeneficiarioDto findBeneficiarioByName(String beneficiarioNome)   throws SQLException;
	List<BeneficiarioDto> findAllBeneficiario()   throws SQLException;
	BeneficiarioDto findBeneficiarioById(Long id) throws SQLException;
	
	void updateBeneficiario(BeneficiarioDto beneficiarioDto)   throws SQLException;
	void deleteBeneficiario(Long id)   throws SQLException;

	 

}
