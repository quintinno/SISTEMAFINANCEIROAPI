package br.com.plataformalancamento.configuration;

import br.com.plataformalancamento.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("homologacao")
public class DatabaseHomologacaoConfiguration {

    @Autowired
    private DatabaseService databaseService;

    @Bean
    public void instanciarBaseDados() {
        this.databaseService.instanciarBaseDados();
    }

}
