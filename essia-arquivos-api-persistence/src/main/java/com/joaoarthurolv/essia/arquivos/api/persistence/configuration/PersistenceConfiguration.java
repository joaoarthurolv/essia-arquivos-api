package com.joaoarthurolv.essia.arquivos.api.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author João Arthur on 18/09/2024
 */
@Configuration
@PropertySource(
        value = { "classpath:persistence-${PERSISTENCE_PROFILE:datasource}.properties",
                "classpath:/persistence-application.properties", "classpath:/application.properties" },
        ignoreResourceNotFound = true)
@ComponentScan("com.joaoarthurolv.essia.arquivos.api.persistence")
@EntityScan("com.joaoarthurolv.essia.arquivos.api.persistence.entity")
@EnableJpaRepositories(basePackages = { "com.joaoarthurolv.essia.arquivos.api.persistence.repository" })
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {
}
