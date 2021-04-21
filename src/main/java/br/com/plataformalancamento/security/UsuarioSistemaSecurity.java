package br.com.plataformalancamento.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.plataformalancamento.enumeration.TipoPerfilUsuarioSistemaEnumeration;

public class UsuarioSistemaSecurity  implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String usuario;
	
	private String senha;
	
	private Collection<? extends GrantedAuthority> grantedAuthorityCollection;
	
	public UsuarioSistemaSecurity() { }
		
	public UsuarioSistemaSecurity(Long codigo, String usuario, String senha, Set<TipoPerfilUsuarioSistemaEnumeration> tipoPerfilUsuarioSistemaEnumerationSet) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.senha = senha;
		this.grantedAuthorityCollection = tipoPerfilUsuarioSistemaEnumerationSet.stream().map( response -> new SimpleGrantedAuthority(response.getPrefixoSpring())).collect(Collectors.toList());
	}	
	
	public Long recuperarCodigo() {
		return codigo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorityCollection;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorityCollection() {
		return grantedAuthorityCollection;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setGrantedAuthorityCollection(Collection<? extends GrantedAuthority> grantedAuthorityCollection) {
		this.grantedAuthorityCollection = grantedAuthorityCollection;
	}

}
