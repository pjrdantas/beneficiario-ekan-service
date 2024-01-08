package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.ekan.controller.DocumentoController;
import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.service.DocumentoService;

@ExtendWith(MockitoExtension.class)
class DocumentoControllerTest {

    @Mock
    private DocumentoService documentoService;

    @InjectMocks
    private DocumentoController documentoController;

    @Test
    void testFindIdBeneficiario() throws SQLException {

        Long idBeneficiario = 1L;
        List<DocumentoDto> expectedDocumentos = Collections.singletonList(new DocumentoDto());

        when(documentoService.findDocumentoByIdBeneficiario(idBeneficiario))
                .thenReturn(expectedDocumentos);

        ResponseEntity<List<DocumentoDto>> responseEntity = documentoController.findIdBeneficiario(idBeneficiario);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedDocumentos, responseEntity.getBody());
    }

    @Test
    void testFindIdBeneficiarioEmptyList() throws SQLException {

        Long idBeneficiario = 2L;

        when(documentoService.findDocumentoByIdBeneficiario(idBeneficiario))
                .thenReturn(Collections.emptyList());

        ResponseEntity<List<DocumentoDto>> responseEntity = documentoController.findIdBeneficiario(idBeneficiario);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testFindIdBeneficiarioException() throws SQLException {

        Long idBeneficiario = 3L;

        when(documentoService.findDocumentoByIdBeneficiario(idBeneficiario))
                .thenThrow(new SQLException("Erro ao obter documentos"));

        ResponseEntity<List<DocumentoDto>> responseEntity = documentoController.findIdBeneficiario(idBeneficiario);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

}
