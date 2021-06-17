package br.com.plataformalancamento.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class DatabaseTesteConfiguration {
/*
    @Autowired
    private DatabaseService databaseService;

    @Bean
    public void instanciarBaseDados() {
        this.databaseService.instanciarBaseDados();
    }
*/
}
