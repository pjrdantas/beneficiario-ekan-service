package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.com.ekan.dto.DocumentoDto;

class DocumentoDtoTest {

    @Test
    void testGetterSetter() {

        DocumentoDto documentoDto = new DocumentoDto();
        Long id = 1L;
        Date documentoDataAtualizacao = new Date();
        Date documentoDataInclusao = new Date();
        String documentoDescricao = "Teste";
        String documentoTipoDocumento = "Tipo";
        Long beneficiarioId = 2L;

        documentoDto.setId(id);
        documentoDto.setDocumentoDataAtualizacao(documentoDataAtualizacao);
        documentoDto.setDocumentoDataInclusao(documentoDataInclusao);
        documentoDto.setDocumentoDescricao(documentoDescricao);
        documentoDto.setDocumentoTipoDocumento(documentoTipoDocumento);
        documentoDto.setBeneficiarioId(beneficiarioId);

        assertEquals(id, documentoDto.getId());
        assertEquals(documentoDataAtualizacao, documentoDto.getDocumentoDataAtualizacao());
        assertEquals(documentoDataInclusao, documentoDto.getDocumentoDataInclusao());
        assertEquals(documentoDescricao, documentoDto.getDocumentoDescricao());
        assertEquals(documentoTipoDocumento, documentoDto.getDocumentoTipoDocumento());
        assertEquals(beneficiarioId, documentoDto.getBeneficiarioId());
    }

    @Test
    void testEqualsAndHashCode() {

        DocumentoDto documentoDto1 = new DocumentoDto(1L, new Date(), new Date(), "Teste", "Tipo", 2L);
        DocumentoDto documentoDto2 = new DocumentoDto(1L, new Date(), new Date(), "Teste", "Tipo", 2L);
        DocumentoDto documentoDto3 = new DocumentoDto(3L, new Date(), new Date(), "Outro", "OutroTipo", 4L);

        assertEquals(documentoDto1, documentoDto2);
        assertNotEquals(documentoDto1, documentoDto3);
        assertEquals(documentoDto1.hashCode(), documentoDto2.hashCode());
        assertNotEquals(documentoDto1.hashCode(), documentoDto3.hashCode());
    }
}
