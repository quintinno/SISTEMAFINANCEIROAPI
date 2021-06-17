package br.com.plataformalancamento.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.service.AutenticacaoService;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("autenticar-login-usuario")
    public ResponseEntity<Boolean> registrarLoginUsuario(@RequestBody UsuarioSistemaDTO usuarioSistemaDTO) {
        return ResponseEntity.ok(autenticacaoService.registrarLoginUsuario(usuarioSistemaDTO));
    }

}
