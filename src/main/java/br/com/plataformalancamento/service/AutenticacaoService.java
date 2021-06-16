package br.com.plataformalancamento.service;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AutenticacaoService implements Serializable {

    public Boolean registrarLoginUsuario(UsuarioSistemaDTO usuarioSistemaDTO) {
        if(usuarioSistemaDTO.getIdentificador().equals("11111111111") && usuarioSistemaDTO.getSenha().equals("123456789")) {
            return true;
        }
        return false;
    }

}
