package com.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("prod")
@EnableJpaRepositories(basePackages = "com.example.repo")
@EntityScan(basePackages = {"com.example.entity"})
@EnableAutoConfiguration
public class ProdConfig {

}
