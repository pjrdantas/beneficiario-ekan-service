package br.com.ekan.beneficiarioekanservice;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.repository.BeneficiarioRepository;
import br.com.ekan.repository.DocumentoRepository;
import br.com.ekan.service.impl.BeneficiarioServiceImpl;

@ExtendWith(MockitoExtension.class)
class BeneficiarioServiceImplTest {

    @Mock
    private BeneficiarioRepository beneficiarioRepository;

    @Mock
    private DocumentoRepository documentoRepository;

    @InjectMocks
    private BeneficiarioServiceImpl beneficiarioService;

    @Test
    void testCreateBeneficiario() throws SQLException {

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        beneficiarioDto.setBeneficiarioNome("Teste Beneficiario");
        beneficiarioDto.setBeneficiarioTelefone("123456789");
        beneficiarioDto.setBeneficiarioDataAtualizacao(new Date());
        beneficiarioDto.setBeneficiarioDataInclusao(new Date());
        beneficiarioDto.setBeneficiarioDataNascimento(new Date());

        DocumentoDto documentoDto = new DocumentoDto();
        documentoDto.setDocumentoDataAtualizacao(new Date());
        documentoDto.setDocumentoDataInclusao(new Date());
        documentoDto.setDocumentoDescricao("Teste Documento");
        documentoDto.setDocumentoTipoDocumento("RG");

        beneficiarioDto.setDocumentos(Collections.singletonList(documentoDto));

    }

    

}
