// DocumentoDto
package br.com.ekan.dto;

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
@JsonPropertyOrder({ "id", "documentoDataAtualizacao", "documentoDataInclusao", "documentoDescricao", "documentoTipoDocumento", "beneficiarioId" })
public class DocumentoDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("documentoDataAtualizacao")
    private String documentoDataAtualizacao;

    @JsonProperty("documentoDataInclusao")
    private String documentoDataInclusao;

    @JsonProperty("documentoDescricao")
    private String documentoDescricao;

    @JsonProperty("documentoTipoDocumento")
    private String documentoTipoDocumento;

    @JsonProperty("beneficiarioId")
    private Long beneficiarioId;

    

    public DocumentoDto() {

    }
}
