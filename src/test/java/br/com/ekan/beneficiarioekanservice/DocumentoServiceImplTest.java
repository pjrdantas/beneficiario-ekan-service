package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.repository.DocumentoRepository;
import br.com.ekan.service.impl.DocumentoServiceImpl;

@ExtendWith(MockitoExtension.class)
class DocumentoServiceImplTest {

    @Mock
    private DocumentoRepository documentoRepository;

    @InjectMocks
    private DocumentoServiceImpl documentoService;

    @Test
    void testFindDocumentoByIdBeneficiario() throws SQLException {

        List<DocumentoDto> expectedDocumentoList = Collections.singletonList(new DocumentoDto());

        when(documentoRepository.findDocumentoByIdBeneficiario(any(Long.class)))
                .thenReturn(expectedDocumentoList);

        List<DocumentoDto> resultDocumentoList = documentoService.findDocumentoByIdBeneficiario(1L);

        assertEquals(expectedDocumentoList, resultDocumentoList);
    }

   
}
