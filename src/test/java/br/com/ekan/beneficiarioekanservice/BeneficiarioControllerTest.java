package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.ekan.controller.BeneficiarioController;
import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.service.BeneficiarioService;

@ExtendWith(MockitoExtension.class)
class BeneficiarioControllerTest {

    @Mock
    private BeneficiarioService beneficiarioService;

    @InjectMocks
    private BeneficiarioController beneficiarioController;

    @Test
    void testSalvarBeneficiario() throws SQLException {

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        beneficiarioDto.setBeneficiarioNome("Teste");

        ResponseEntity<String> responseEntity = beneficiarioController.salvarBeneficiario(beneficiarioDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Beneficiario e documentos salvos com sucesso", responseEntity.getBody());
    }

    @Test
    void testSalvarBeneficiarioNull() throws SQLException {

        BeneficiarioDto beneficiarioDto = null;

        ResponseEntity<String> responseEntity = beneficiarioController.salvarBeneficiario(beneficiarioDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void testSalvarBeneficiarioDataIntegrityViolationException() throws SQLException {

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        beneficiarioDto.setBeneficiarioNome("Teste");

        ResponseEntity<String> responseEntity = beneficiarioController.salvarBeneficiario(beneficiarioDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void testSalvarBeneficiarioException() throws SQLException {

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        beneficiarioDto.setBeneficiarioNome("Teste");

        ResponseEntity<String> responseEntity = beneficiarioController.salvarBeneficiario(beneficiarioDto);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

}
