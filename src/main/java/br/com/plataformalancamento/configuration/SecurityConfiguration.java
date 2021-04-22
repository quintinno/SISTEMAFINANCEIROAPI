package br.com.plataformalancamento.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment environment;
	
	private static final String[] PUBLIC_ENDPOINT_LEITURA_ESCRITA = {
			"/pessoa/**",
			"/tipo-pessoa/**",
			"/contrato/**",
			"/usuario-sistema/**"
	};
	
	private static final String[] PUBLIC_ENDPOINT_LEITURA = {
			"/pessoa/**",
			"/tipo-pessoa/**",
			"/contrato/**",
			"/categoria-despesa/**",
			"/forma-pagamento/**",
			"/tipo-canal-pagamento/**",
			"/cartao-bancario/**",
			"/produto-servico/**",
			"/despesa/**"
	};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		if(Arrays.asList(environment.getActiveProfiles()).contains("teste")) {
			httpSecurity.headers().frameOptions().disable();
		}
		httpSecurity.cors().and().csrf().disable();
		httpSecurity.authorizeRequests()
		.antMatchers(HttpMethod.GET, PUBLIC_ENDPOINT_LEITURA).permitAll()
		.antMatchers(PUBLIC_ENDPOINT_LEITURA_ESCRITA).permitAll()
		.anyRequest().authenticated();
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
			urlBasedCorsConfigurationSource.registerCorsConfiguration("/*/", new CorsConfiguration().applyPermitDefaultValues());
		return urlBasedCorsConfigurationSource;
	}
	
	@Bean 
	public BCryptPasswordEncoder criptografarDados() {
		return new BCryptPasswordEncoder();
	}
	
}
