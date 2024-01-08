package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.repository.impl.BeneficiarioRepositoryImpl;

@ExtendWith(MockitoExtension.class)
class BeneficiarioRepositoryImplTest {



    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @InjectMocks
    private BeneficiarioRepositoryImpl beneficiarioRepository;

    @Test
    void testCreateBeneficiario() throws SQLException {
 
        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        beneficiarioDto.setBeneficiarioNome("Teste");
        beneficiarioDto.setBeneficiarioTelefone("123456789");
        beneficiarioDto.setBeneficiarioDataAtualizacao(new Date());
        beneficiarioDto.setBeneficiarioDataInclusao(new Date());
        beneficiarioDto.setBeneficiarioDataNascimento(new Date());        
        beneficiarioRepository.createBeneficiario(beneficiarioDto);        
    }

    @Test
    void testCreateBeneficiarioError() throws SQLException {

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        beneficiarioDto.setBeneficiarioNome("Teste");
        beneficiarioDto.setBeneficiarioTelefone("123456789");
        beneficiarioDto.setBeneficiarioDataAtualizacao(new Date());
        beneficiarioDto.setBeneficiarioDataInclusao(new Date());
        beneficiarioDto.setBeneficiarioDataNascimento(new Date());
        


    }

    @SuppressWarnings("unused")
	@Test
    void testFindBeneficiarioByName() throws SQLException {

        BeneficiarioDto expectedBeneficiario = new BeneficiarioDto(1L, "Teste", "123456789", new Date(), new Date(), new Date(), null);      
        BeneficiarioDto resultBeneficiario = beneficiarioRepository.findBeneficiarioByName("Teste");
    }

    @Test
    void testFindBeneficiarioByNameNotFound() throws SQLException {
       
        BeneficiarioDto resultBeneficiario = beneficiarioRepository.findBeneficiarioByName("Teste");
        assertEquals(null, resultBeneficiario);
    }

    @SuppressWarnings("unused")
	@Test
    void testFindAllBeneficiario() throws SQLException {
        List<BeneficiarioDto> resultBeneficiarioList = beneficiarioRepository.findAllBeneficiario();
    }

    @Test
    void testUpdateBeneficiario() throws SQLException {
    }

    @Test
    void testUpdateBeneficiarioError() throws SQLException {

    }

    @Test
    void testDeleteBeneficiario() throws SQLException {
        beneficiarioRepository.deleteBeneficiario(1L);
     
    }

    
}
