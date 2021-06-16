package br.com.plataformalancamento.controller;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController implements Serializable {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("autenticar-login-usuario")
    public ResponseEntity<Boolean> registrarLoginUsuario(@RequestBody UsuarioSistemaDTO usuarioSistemaDTO) {
        return ResponseEntity.ok(autenticacaoService.registrarLoginUsuario(usuarioSistemaDTO));
    }

}
