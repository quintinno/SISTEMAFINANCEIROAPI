package br.com.plataformalancamento.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;

@Service
public class AutenticacaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	// TODO -- Implementar consulta ao banco de dados
	public Boolean registrarLoginUsuario(UsuarioSistemaDTO usuarioSistemaDTO) {
		try {
			if (usuarioSistemaDTO.getIdentificador().equals("sistemafinanceiro@sistemafinanceiro.com.br") &&
				usuarioSistemaDTO.getSenha().equals("sistemafinanceiro")) {
				return true;
			}
		} catch (Exception e) {
//			throw new NullPointerException(ConfiguradorErrorException.recuperarMensagemErroObjetoAutenticacaoInviavel());
			return false;
		}
        return false;
    }

}
