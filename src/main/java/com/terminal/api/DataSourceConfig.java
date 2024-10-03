package com.terminal.api;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	 @Value("${app.path.access.datasource.url}")
	 private String rutaBD;
	 
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:ucanaccess://" + rutaBD);
        config.setDriverClassName("net.ucanaccess.jdbc.UcanaccessDriver");
        // Configura el pool según sea necesario
        return new HikariDataSource(config);
    }
}