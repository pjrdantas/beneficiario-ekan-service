package br.com.ekan.beneficiarioekanservice;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.repository.impl.DocumentoRepositoryImpl;

@ExtendWith(MockitoExtension.class)
class DocumentoRepositoryImplTest {

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @InjectMocks
    private DocumentoRepositoryImpl documentoRepository;

    @Test
    void testCreateDocumento() throws SQLException {
        
        DocumentoDto documentoDto = new DocumentoDto();
        documentoDto.setDocumentoDataAtualizacao(null);  
        documentoRepository.createDocumento(documentoDto);

    }

    @SuppressWarnings("unused")
	@Test
    void testFindDocumentoByIdBeneficiario() throws SQLException {
         
        List<DocumentoDto> expectedDocumentoList = Collections.singletonList(new DocumentoDto());
        List<DocumentoDto> resultDocumentoList = documentoRepository.findDocumentoByIdBeneficiario(1L);

    }

}
