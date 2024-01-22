package org.workshop.companyservice.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String urlDatabase;
    @Value("${spring.datasource.password}")
    private String passwordDatabase;
    @Value("${spring.datasource.username}")
    private String usernameDatabase;
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(urlDatabase);
        dataSource.setUsername(usernameDatabase);
        dataSource.setPassword(passwordDatabase);
        dataSource.setSchema("fernandes");
        return dataSource;
    }
}
