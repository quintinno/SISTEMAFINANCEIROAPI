package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.entity.UsuarioSistemaEntity;
import br.com.plataformalancamento.exception.ConfiguradorErrorException;

@Repository
public class UsuarioSistemaImplementacaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public UsuarioSistemaEntity autenticarDadosUsuarioSistema(String identificador, String senha) {
		StringBuilder query = new StringBuilder("SELECT usuarioSistemaEntity ")
			.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ")
			.append("WHERE usuarioSistemaEntity.identificador = :identificadorParamenter ")
			.append("AND usuarioSistemaEntity.senha= :senhaParamenter ");
		TypedQuery<UsuarioSistemaEntity> typeQuery = entityManager.createQuery(query.toString(), UsuarioSistemaEntity.class);
			typeQuery.setParameter("identificadorParamenter", identificador);
			typeQuery.setParameter("senhaParamenter", senha);
		return typeQuery.getSingleResult();
	}
	
	public UsuarioSistemaDTO isUsuarioCadastrado(UsuarioSistemaDTO usuarioSistemaDTO) {
		StringBuilder query = new StringBuilder("SELECT usuarioSistemaEntity ")
			.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ")
			.append("WHERE usuarioSistemaEntity.identificador = :identificadorParamenter ")
			.append("AND usuarioSistemaEntity.senha= :senhaParamenter ");
		TypedQuery<UsuarioSistemaEntity> typeQuery = entityManager.createQuery(query.toString(), UsuarioSistemaEntity.class);
			typeQuery.setParameter("identificadorParamenter", usuarioSistemaDTO.getIdentificador());
			typeQuery.setParameter("senhaParamenter", usuarioSistemaDTO.getSenha());
		List<UsuarioSistemaEntity> usuarioSistemaEntityList = typeQuery.getResultList();
		if(usuarioSistemaEntityList.isEmpty()) {
			throw new br.com.plataformalancamento.exception.EmptyResultDataAccessException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoAutenticacao());
		}
		return new UsuarioSistemaDTO(usuarioSistemaEntityList.get(0).getIdentificador(), usuarioSistemaEntityList.get(0).getSenha());
	}
	
}
