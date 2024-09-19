package com.joaoarthurolv.essia.arquivos.api.rest.producer.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author João Arthur on 18/09/2024
 */
@Configuration
@ComponentScan(basePackages = {
        "com.joaoarthurolv.essia.arquivos.api",
        "com.joaoarthurolv.essia.arquivos.api.rest.producer"})
public class RestProducerConfiguration {
}
