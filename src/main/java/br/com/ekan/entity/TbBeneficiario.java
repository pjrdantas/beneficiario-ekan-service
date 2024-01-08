package br.com.ekan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the TB_BENEFICIARIO database table.
 * 
 */

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name="TB_BENEFICIARIO")
public class TbBeneficiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(name="TB_BENEFICIARIO_NOME")
	private String tbBeneficiarioNome;

	@Column(name="TB_BENEFICIARIO_TELEFONE")
	private String tbBeneficiarioTelefone;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TB_BENEFICIARIO_DATA_ATUALIZACAO")
	private Date tbBeneficiarioDataAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_BENEFICIARIO_DATA_INCLUSAO")
	private Date tbBeneficiarioDataInclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="TB_BENEFICIARIO_DATA_NASCIMENTO")
	private Date tbBeneficiarioDataNascimento;


	//bi-directional many-to-one association to TbDocumento
	@OneToMany(mappedBy="tbBeneficiario")
	private List<TbDocumento> tbDocumentos;

	public TbBeneficiario() {
	}


}