package com.example.flyway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
    @Bean(name="flyway")
    public Flyway getFlywayDev() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSourceDev());
        flyway.setInitOnMigrate(true);
        flyway.migrate();
        return flyway;
    }
   /* @Primary
    @Profile("dev")
    @Bean(name = "dataSource")
    public DataSource dataSourceDev() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env
                .getProperty("datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));

        return dataSource;
    }*/
}
