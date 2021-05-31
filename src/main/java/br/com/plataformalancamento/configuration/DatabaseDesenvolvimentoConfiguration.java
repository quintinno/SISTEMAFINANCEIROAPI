package br.com.plataformalancamento.configuration;

import br.com.plataformalancamento.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("desenvolvimento")
public class DatabaseDesenvolvimentoConfiguration {

    @Autowired
    private DatabaseService databaseService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String estrategia;

    @Bean
    public boolean instanciarBaseDados() {
        if(estrategia.equals("update")) {
            this.databaseService.instanciarBaseDados();
        }
        return false;
    }

}
