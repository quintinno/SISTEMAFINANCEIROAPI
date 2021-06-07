package br.com.plataformalancamento.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		List<UsuarioSistemaEntity> usuarioSistemaEntityList = typeQuery.getResultList();
			if(usuarioSistemaEntityList.isEmpty()) {
				throw new br.com.plataformalancamento.exception.EmptyResultDataAccessException(ConfiguradorErrorException.recuperarMensagemErroObjetoNaoEncontradoAutenticacao());
			}
		return usuarioSistemaEntityList.get(0);
	}
	
	public UsuarioSistemaEntity isUsuarioCadastrado(UsuarioSistemaDTO usuarioSistemaDTO) {
		try {
			StringBuilder query = new StringBuilder("SELECT usuarioSistemaEntity ")
					.append("FROM UsuarioSistemaEntity usuarioSistemaEntity ")
					.append("WHERE usuarioSistemaEntity.identificador = :identificadorParamenter ")
					.append("AND usuarioSistemaEntity.senha= :senhaParamenter ");
			TypedQuery<UsuarioSistemaEntity> typeQuery = entityManager.createQuery(query.toString(), UsuarioSistemaEntity.class);
				typeQuery.setParameter("identificadorParamenter", usuarioSistemaDTO.getIdentificador());
				typeQuery.setParameter("senhaParamenter", usuarioSistemaDTO.getSenha());
			return typeQuery.getSingleResult();
		} catch (NoResultException noResultException) { }
		return null;
	}
	
}
