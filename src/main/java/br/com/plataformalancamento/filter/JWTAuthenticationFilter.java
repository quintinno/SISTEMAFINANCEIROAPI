package br.com.plataformalancamento.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.plataformalancamento.dto.UsuarioSistemaDTO;
import br.com.plataformalancamento.security.UsuarioSistemaSecurity;
import br.com.plataformalancamento.utility.JWTUtility;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	private JWTUtility jWTUtility;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtility jWTUtility) {
		this.authenticationManager = authenticationManager;
		this.jWTUtility = jWTUtility;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			UsuarioSistemaDTO usuarioSistemaDTO = new ObjectMapper().readValue(request.getInputStream(), UsuarioSistemaDTO.class);
	        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuarioSistemaDTO.getUsuario(), usuarioSistemaDTO.getSenha(), new ArrayList<>());
	        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
	        return authentication;
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		String username = ((UsuarioSistemaSecurity) authResult.getPrincipal()).getUsername();
        String token = jWTUtility.generateToken(username);
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
	}
	
}
