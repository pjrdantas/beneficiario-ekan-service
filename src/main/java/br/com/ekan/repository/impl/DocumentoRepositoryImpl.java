package br.com.ekan.repository.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ekan.dto.DocumentoDto;
import br.com.ekan.repository.DocumentoRepository;

@Transactional
@Repository
public class DocumentoRepositoryImpl implements DocumentoRepository {
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	SimpleDateFormat formatador  = new SimpleDateFormat("dd/MM/yyyy");
	String dataFormatada;
	Date data;


	@Override
	public void createDocumento(DocumentoDto documentoDto) throws SQLException {
	    try {
	        StringBuilder sql = new StringBuilder();
	        sql.append("INSERT INTO TB_DOCUMENTO (");
	        sql.append("  TB_DOCUMENTO_DATA_ATUALIZACAO, ");
	        sql.append("  TB_DOCUMENTO_DATA_INCLUSAO, ");
	        sql.append("  TB_DOCUMENTO_DESCRICAO, ");
	        sql.append("  TB_DOCUMENTO_TIPO_DOCUMENTO, ");
	        sql.append("  TB_BENEFICIARIO_ID) ");
	        sql.append("VALUES (:tbDocumentoDataAtualizacao, :tbDocumentoDataInclusao, :tbDocumentoDescricao, :tbDocumentoTipoDocumento, :tbBeneficiarioId)");

	        SqlParameterSource params = new MapSqlParameterSource()
	                .addValue("tbDocumentoDataAtualizacao", documentoDto.getDocumentoDataAtualizacao())
	                .addValue("tbDocumentoDataInclusao", documentoDto.getDocumentoDataInclusao())
	                .addValue("tbDocumentoDescricao", documentoDto.getDocumentoDescricao())
	                .addValue("tbDocumentoTipoDocumento", documentoDto.getDocumentoTipoDocumento())
	                .addValue("tbBeneficiarioId", documentoDto.getBeneficiarioId());

	        jdbcTemplate.update(sql.toString(), params);
	    } catch (Exception e) {
	        throw new SQLException("Erro ao criar o documento", e);
	    }
	}

	
	
	@Override
	public List<DocumentoDto> findDocumentoByIdBeneficiario(Long id) throws SQLException {
	    StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
	    sql.append(" WHERE TB_BENEFICIARIO_ID = :tbBeneficiarioId"); 
	    sql.append(" ORDER BY ID "); 
	    SqlParameterSource params = new MapSqlParameterSource().addValue("tbBeneficiarioId", id);
	    return devolveListaObjetos(sql, params);
	}

	
	@Override
	public DocumentoDto findDocumentoById(Long id) throws SQLException {
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
	    sql.append(" WHERE ID = :id");
	    SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
	    return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
	    	DocumentoDto documentoDto = new DocumentoDto();
	        documentoDto.setId(rs.getLong("ID")); 
	        documentoDto.setDocumentoTipoDocumento(rs.getString("TB_DOCUMENTO_TIPO_DOCUMENTO"));
	        documentoDto.setDocumentoDescricao(rs.getString("TB_DOCUMENTO_DESCRICAO"));
	        dataFormatada = formatador.format(rs.getDate("TB_DOCUMENTO_DATA_INCLUSAO"));
	        documentoDto.setDocumentoDataInclusao(dataFormatada);
	        dataFormatada = formatador.format(rs.getDate("TB_DOCUMENTO_DATA_ATUALIZACAO"));
	        documentoDto.setDocumentoDataAtualizacao(dataFormatada);	        
	        documentoDto.setBeneficiarioId(rs.getLong("TB_BENEFICIARIO_ID"));
	        return documentoDto;
	    });
	    
	}


	
	
	
	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
	        .append("SELECT DISTINCT")
	        .append(" ID") 
	        .append(" ,TB_DOCUMENTO_TIPO_DOCUMENTO")
	        .append(" ,TB_DOCUMENTO_DESCRICAO")
	        .append(" ,TB_DOCUMENTO_DATA_INCLUSAO")
	        .append(" ,TB_DOCUMENTO_DATA_ATUALIZACAO") 
	        .append(" ,TB_BENEFICIARIO_ID")
	        .append(" FROM TB_DOCUMENTO ");

	private List<DocumentoDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
	    return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
	        DocumentoDto documentoDto = new DocumentoDto();
	        documentoDto.setId(rs.getLong("ID")); 
	        documentoDto.setDocumentoTipoDocumento(rs.getString("TB_DOCUMENTO_TIPO_DOCUMENTO"));
	        documentoDto.setDocumentoDescricao(rs.getString("TB_DOCUMENTO_DESCRICAO"));
	        dataFormatada = formatador.format(rs.getDate("TB_DOCUMENTO_DATA_INCLUSAO"));
	        documentoDto.setDocumentoDataInclusao(dataFormatada);
	        dataFormatada = formatador.format(rs.getDate("TB_DOCUMENTO_DATA_ATUALIZACAO"));
	        documentoDto.setDocumentoDataAtualizacao(dataFormatada);	        
	        documentoDto.setBeneficiarioId(rs.getLong("TB_BENEFICIARIO_ID"));
	        return documentoDto;
	    });
	}
	


	
	
	
	
	
	
	
	
	



	@Override
	public void deleteDocumento(Long id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_DOCUMENTO ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}




}
