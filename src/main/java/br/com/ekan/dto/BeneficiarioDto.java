// BeneficiarioDto
package br.com.ekan.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id",  "beneficiarioNome", "beneficiarioTelefone", "beneficiarioDataAtualizacao", "beneficiarioDataInclusao", "beneficiarioDataNascimento", "documentos" })
public class BeneficiarioDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("beneficiarioNome")
    private String beneficiarioNome;

    @JsonProperty("beneficiarioTelefone")
    private String beneficiarioTelefone;
    
    @JsonProperty("beneficiarioDataAtualizacao")
    private Date beneficiarioDataAtualizacao;

    @JsonProperty("beneficiarioDataInclusao")
    private Date beneficiarioDataInclusao;

    @JsonProperty("beneficiarioDataNascimento")
    private Date beneficiarioDataNascimento;

    @JsonProperty("documentos")
    private List<DocumentoDto> documentos;


    public BeneficiarioDto() {

    }
}
