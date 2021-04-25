package br.com.plataformalancamento.configuration;

import br.com.plataformalancamento.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("homologacao")
public class DatabaseHomologacaoConfiguration {
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
    private String estrategia;

    @Autowired
    private DatabaseService databaseService;

    @Bean
    public void instanciarBaseDados() {
    	if(estrategia.equals("create-drop")) {
            this.databaseService.instanciarBaseDados();
        }
    }

}
