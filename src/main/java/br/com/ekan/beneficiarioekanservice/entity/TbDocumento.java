package br.com.ekan.beneficiarioekanservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the TB_DOCUMENTO database table.
 * 
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_DOCUMENTO")

public class TbDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_DOCUMENTO_DATA_ATUALIZACAO")
	private Date tbDocumentoDataAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_DOCUMENTO_DATA_INCLUSAO")
	private Date tbDocumentoDataInclusao;

	@Column(name="TB_DOCUMENTO_DESCRICAO")
	private String tbDocumentoDescricao;

	@Column(name="TB_DOCUMENTO_TIPO_DOCUMENTO")
	private String tbDocumentoTipoDocumento;

	//bi-directional many-to-one association to TbBeneficiario
	@ManyToOne
	@JoinColumn(name="TB_BENEFICIARIO_ID")
	private TbBeneficiario tbBeneficiario;

	public TbDocumento() {
	}



}