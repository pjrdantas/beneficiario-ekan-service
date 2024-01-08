package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.com.ekan.entity.TbBeneficiario;

class TbBeneficiarioTest {

    @Test
    void testGetterSetter() {

        TbBeneficiario tbBeneficiario = new TbBeneficiario();
        Long id = 1L;
        String tbBeneficiarioNome = "Teste";
        String tbBeneficiarioTelefone = "123456789";
        Date tbBeneficiarioDataAtualizacao = new Date();
        Date tbBeneficiarioDataInclusao = new Date();
        Date tbBeneficiarioDataNascimento = new Date();

        tbBeneficiario.setId(id);
        tbBeneficiario.setTbBeneficiarioNome(tbBeneficiarioNome);
        tbBeneficiario.setTbBeneficiarioTelefone(tbBeneficiarioTelefone);
        tbBeneficiario.setTbBeneficiarioDataAtualizacao(tbBeneficiarioDataAtualizacao);
        tbBeneficiario.setTbBeneficiarioDataInclusao(tbBeneficiarioDataInclusao);
        tbBeneficiario.setTbBeneficiarioDataNascimento(tbBeneficiarioDataNascimento);

        assertEquals(id, tbBeneficiario.getId());
        assertEquals(tbBeneficiarioNome, tbBeneficiario.getTbBeneficiarioNome());
        assertEquals(tbBeneficiarioTelefone, tbBeneficiario.getTbBeneficiarioTelefone());
        assertEquals(tbBeneficiarioDataAtualizacao, tbBeneficiario.getTbBeneficiarioDataAtualizacao());
        assertEquals(tbBeneficiarioDataInclusao, tbBeneficiario.getTbBeneficiarioDataInclusao());
        assertEquals(tbBeneficiarioDataNascimento, tbBeneficiario.getTbBeneficiarioDataNascimento());
    }

    @Test
    void testEqualsAndHashCode() {

        TbBeneficiario tbBeneficiario1 = new TbBeneficiario(1L, "Teste", "123456789", new Date(), new Date(), new Date(), null);
        TbBeneficiario tbBeneficiario2 = new TbBeneficiario(1L, "Teste", "123456789", new Date(), new Date(), new Date(), null);
        TbBeneficiario tbBeneficiario3 = new TbBeneficiario(3L, "Outro", "987654321", new Date(), new Date(), new Date(), null);

        assertEquals(tbBeneficiario1, tbBeneficiario2);
        assertNotEquals(tbBeneficiario1, tbBeneficiario3);
        assertEquals(tbBeneficiario1.hashCode(), tbBeneficiario2.hashCode());
        assertNotEquals(tbBeneficiario1.hashCode(), tbBeneficiario3.hashCode());
    }
}
