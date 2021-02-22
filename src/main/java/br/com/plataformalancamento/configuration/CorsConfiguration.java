package br.com.plataformalancamento.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class CorsConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
	}

}
