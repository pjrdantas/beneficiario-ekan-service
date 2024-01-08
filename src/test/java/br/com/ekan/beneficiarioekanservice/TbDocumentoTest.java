package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.com.ekan.entity.TbBeneficiario;
import br.com.ekan.entity.TbDocumento;

class TbDocumentoTest {

    @Test
    void testGetterSetter() {

        TbBeneficiario tbBeneficiario = new TbBeneficiario();
        Long id = 1L;
        Date tbDocumentoDataAtualizacao = new Date();
        Date tbDocumentoDataInclusao = new Date();
        String tbDocumentoDescricao = "Teste";
        String tbDocumentoTipoDocumento = "Tipo";

        TbDocumento tbDocumento = new TbDocumento();
        tbDocumento.setId(id);
        tbDocumento.setTbDocumentoDataAtualizacao(tbDocumentoDataAtualizacao);
        tbDocumento.setTbDocumentoDataInclusao(tbDocumentoDataInclusao);
        tbDocumento.setTbDocumentoDescricao(tbDocumentoDescricao);
        tbDocumento.setTbDocumentoTipoDocumento(tbDocumentoTipoDocumento);
        tbDocumento.setTbBeneficiario(tbBeneficiario);

        assertEquals(id, tbDocumento.getId());
        assertEquals(tbDocumentoDataAtualizacao, tbDocumento.getTbDocumentoDataAtualizacao());
        assertEquals(tbDocumentoDataInclusao, tbDocumento.getTbDocumentoDataInclusao());
        assertEquals(tbDocumentoDescricao, tbDocumento.getTbDocumentoDescricao());
        assertEquals(tbDocumentoTipoDocumento, tbDocumento.getTbDocumentoTipoDocumento());
        assertEquals(tbBeneficiario, tbDocumento.getTbBeneficiario());
    }

    @Test
    void testEqualsAndHashCode() {

        Date currentDate = new Date();
        TbBeneficiario tbBeneficiario = new TbBeneficiario(1L, "Teste", "123456789", currentDate, currentDate, currentDate, null);

        TbDocumento tbDocumento1 = new TbDocumento(1L, currentDate, currentDate, "Teste", "Tipo", tbBeneficiario);
        TbDocumento tbDocumento2 = new TbDocumento(1L, currentDate, currentDate, "Teste", "Tipo", tbBeneficiario);
        TbDocumento tbDocumento3 = new TbDocumento(3L, currentDate, currentDate, "Outro", "OutroTipo", tbBeneficiario);

        assertEquals(tbDocumento1, tbDocumento2);
        assertNotEquals(tbDocumento1, tbDocumento3);
        assertEquals(tbDocumento1.hashCode(), tbDocumento2.hashCode());
        assertNotEquals(tbDocumento1.hashCode(), tbDocumento3.hashCode());
    }
}
