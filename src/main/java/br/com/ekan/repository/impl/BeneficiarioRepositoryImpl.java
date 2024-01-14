package br.com.ekan.repository.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ekan.dto.BeneficiarioDto;
import br.com.ekan.repository.BeneficiarioRepository;

@Transactional
@Repository
public class BeneficiarioRepositoryImpl implements BeneficiarioRepository {
	
	
	private static final Logger _logger = LoggerFactory.getLogger(BeneficiarioRepositoryImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
	SimpleDateFormat formatador  = new SimpleDateFormat("dd/MM/yyyy");
	String dataFormatada;
	Date data;

    @Override
    public void createBeneficiario(BeneficiarioDto beneficiarioDto) throws SQLException {
    	
   
    	
    	StringBuilder sql = new StringBuilder();
		sql.append("  INSERT INTO ");
		sql.append("  TB_BENEFICIARIO (");
		sql.append("  TB_BENEFICIARIO_NOME, ");
		sql.append("  TB_BENEFICIARIO_TELEFONE, ");
		sql.append("  TB_BENEFICIARIO_DATA_ATUALIZACAO, ");
		sql.append("  TB_BENEFICIARIO_DATA_INCLUSAO, ");
		sql.append("  TB_BENEFICIARIO_DATA_NASCIMENTO) ");
		sql.append("  values (:tbBeneficiarioNome, :tbBeneficiarioTelefone, :tbBeneficiarioDataAtualizacao, :tbBeneficiarioDataInclusao, :tbBeneficiarioDataNascimento)");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("tbBeneficiarioNome", beneficiarioDto.getBeneficiarioNome())
				.addValue("tbBeneficiarioTelefone", beneficiarioDto.getBeneficiarioTelefone())
				.addValue("tbBeneficiarioDataAtualizacao", beneficiarioDto.getBeneficiarioDataAtualizacao())
				.addValue("tbBeneficiarioDataInclusao", beneficiarioDto.getBeneficiarioDataInclusao())
				.addValue("tbBeneficiarioDataNascimento", beneficiarioDto.getBeneficiarioDataNascimento());

		jdbcTemplate.update(sql.toString(), params);
   
    }

	@Override
	public BeneficiarioDto findBeneficiarioByName(String beneficiarioNome) throws SQLException {
	    StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
	    sql.append(" WHERE TB_BENEFICIARIO_NOME = :tbBeneficiarioNome");
	    SqlParameterSource params = new MapSqlParameterSource().addValue("tbBeneficiarioNome", beneficiarioNome);
	    return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
	        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();            
	        beneficiarioDto.setId(rs.getLong("id"));
	        beneficiarioDto.setBeneficiarioNome(rs.getString("TB_BENEFICIARIO_NOME"));
			beneficiarioDto.setBeneficiarioTelefone(rs.getString("TB_BENEFICIARIO_TELEFONE"));
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_ATUALIZACAO"));
			beneficiarioDto.setBeneficiarioDataAtualizacao(dataFormatada);
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_INCLUSAO"));
			beneficiarioDto.setBeneficiarioDataInclusao(dataFormatada);
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_NASCIMENTO"));
			beneficiarioDto.setBeneficiarioDataNascimento(dataFormatada);
	        _logger.info("...id do beneficiario :" + beneficiarioDto.getId());
	        return beneficiarioDto;
	    });	    
	}
	
	@Override
	public BeneficiarioDto findBeneficiarioById(Long id) throws SQLException {
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);
	    sql.append(" WHERE ID = :id");
	    SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
	    return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
	        BeneficiarioDto beneficiarioDto = new BeneficiarioDto();            
	        beneficiarioDto.setId(rs.getLong("ID"));
	        beneficiarioDto.setBeneficiarioNome(rs.getString("TB_BENEFICIARIO_NOME"));
			beneficiarioDto.setBeneficiarioTelefone(rs.getString("TB_BENEFICIARIO_TELEFONE"));
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_ATUALIZACAO"));
			beneficiarioDto.setBeneficiarioDataAtualizacao(dataFormatada);
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_INCLUSAO"));
			beneficiarioDto.setBeneficiarioDataInclusao(dataFormatada);
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_NASCIMENTO"));
			beneficiarioDto.setBeneficiarioDataNascimento(dataFormatada);
	        return beneficiarioDto;
	    });	    
	}


	@Override
	public List<BeneficiarioDto> findAllBeneficiario() throws SQLException {
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal).append(" order by id ");
		return devolveListaObjetos(sql, null);
	}
	
	
	final static StringBuilder sqlSelectPrincipal = new StringBuilder()
			.append("  SELECT DISTINCT")
			.append("  id")
			.append("  ,TB_BENEFICIARIO_NOME")
			.append("  ,TB_BENEFICIARIO_TELEFONE")
			.append("  ,TB_BENEFICIARIO_DATA_ATUALIZACAO")
			.append("  ,TB_BENEFICIARIO_DATA_INCLUSAO")
			.append("  ,TB_BENEFICIARIO_DATA_NASCIMENTO")
			.append("  FROM TB_BENEFICIARIO ");
	

	private List<BeneficiarioDto> devolveListaObjetos(StringBuilder sql, SqlParameterSource params) {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
			BeneficiarioDto beneficiarioDto = new BeneficiarioDto();
			beneficiarioDto.setId(rs.getLong("id"));
			beneficiarioDto.setBeneficiarioNome(rs.getString("TB_BENEFICIARIO_NOME"));
			beneficiarioDto.setBeneficiarioTelefone(rs.getString("TB_BENEFICIARIO_TELEFONE"));
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_ATUALIZACAO"));
			beneficiarioDto.setBeneficiarioDataAtualizacao(dataFormatada);
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_INCLUSAO"));
			beneficiarioDto.setBeneficiarioDataInclusao(dataFormatada);
			dataFormatada = formatador.format(rs.getDate("TB_BENEFICIARIO_DATA_NASCIMENTO"));
			beneficiarioDto.setBeneficiarioDataNascimento(dataFormatada);
			return beneficiarioDto;
		});
	}
		
	
	@Override
	public void updateBeneficiario(BeneficiarioDto beneficiarioDto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE TB_BENEFICIARIO ");
		sql.append(" SET  ");
		sql.append(" TB_BENEFICIARIO_NOME = :tbBeneficiarioNome, ");
		sql.append(" TB_BENEFICIARIO_TELEFONE = :tbBeneficiarioTelefone, ");
		sql.append(" TB_BENEFICIARIO_DATA_ATUALIZACAO = :tbBeneficiarioDataAtualizacao, ");
		sql.append(" TB_BENEFICIARIO_DATA_INCLUSAO = :tbBeneficiarioDataInclusao, ");
		sql.append(" TB_BENEFICIARIO_DATA_NASCIMENTO = :tbBeneficiarioDataNascimento");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", beneficiarioDto.getId())
				.addValue("tbBeneficiarioNome", beneficiarioDto.getBeneficiarioNome())
				.addValue("tbBeneficiarioTelefone", beneficiarioDto.getBeneficiarioTelefone())
				.addValue("tbBeneficiarioDataAtualizacao", beneficiarioDto.getBeneficiarioDataAtualizacao())
				.addValue("tbBeneficiarioDataInclusao", beneficiarioDto.getBeneficiarioDataInclusao())
				.addValue("tbBeneficiarioDataNascimento", beneficiarioDto.getBeneficiarioDataNascimento());
		jdbcTemplate.update(sql.toString(), params);
		
	}

	@Override
	public void deleteBeneficiario(Long id) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM ");
		sql.append(" TB_BENEFICIARIO ");
		sql.append(" WHERE id = :id");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update(sql.toString(), params);
		
	}



}
