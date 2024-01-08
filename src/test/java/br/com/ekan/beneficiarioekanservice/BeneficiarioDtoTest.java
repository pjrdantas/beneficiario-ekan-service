package br.com.ekan.beneficiarioekanservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.dto.DocumentoDto;

class BeneficiarioDtoTest {

    @Test
    void testGetterSetter() {

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
        Long id = 1L;
        String beneficiarioNome = "Teste";
        String beneficiarioTelefone = "123456789";
        Date beneficiarioDataAtualizacao = new Date();
        Date beneficiarioDataInclusao = new Date();
        Date beneficiarioDataNascimento = new Date();
        List<DocumentoDto> documentos = new ArrayList<>();

        beneficiarioDto.setId(id);
        beneficiarioDto.setBeneficiarioNome(beneficiarioNome);
        beneficiarioDto.setBeneficiarioTelefone(beneficiarioTelefone);
        beneficiarioDto.setBeneficiarioDataAtualizacao(beneficiarioDataAtualizacao);
        beneficiarioDto.setBeneficiarioDataInclusao(beneficiarioDataInclusao);
        beneficiarioDto.setBeneficiarioDataNascimento(beneficiarioDataNascimento);
        beneficiarioDto.setDocumentos(documentos);

        assertEquals(id, beneficiarioDto.getId());
        assertEquals(beneficiarioNome, beneficiarioDto.getBeneficiarioNome());
        assertEquals(beneficiarioTelefone, beneficiarioDto.getBeneficiarioTelefone());
        assertEquals(beneficiarioDataAtualizacao, beneficiarioDto.getBeneficiarioDataAtualizacao());
        assertEquals(beneficiarioDataInclusao, beneficiarioDto.getBeneficiarioDataInclusao());
        assertEquals(beneficiarioDataNascimento, beneficiarioDto.getBeneficiarioDataNascimento());
        assertEquals(documentos, beneficiarioDto.getDocumentos());
    }

    @SuppressWarnings("unused")
	@Test
    void testEqualsAndHashCode() {

        BeneficiarioDto beneficiarioDto1 = new BeneficiarioDto(1L, "Teste", "123456789", new Date(), new Date(),
                new Date(), new ArrayList<>());
        BeneficiarioDto beneficiarioDto2 = new BeneficiarioDto(1L, "Teste", "123456789", new Date(), new Date(),
                new Date(), new ArrayList<>());
        BeneficiarioDto beneficiarioDto3 = new BeneficiarioDto(2L, "Outro", "987654321", new Date(), new Date(),
                new Date(), new ArrayList<>());


    }
}
