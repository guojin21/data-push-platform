package com.guojin.dpp.master;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @describe: 数据源配置
 * @author: guojin
 * @date: 2018/8/2 17:59
 **/
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.dpp.url}")
    private String dbUrl;

    @Value("${spring.datasource.dpp.username}")
    private String username;

    @Value("${spring.datasource.dpp.password}")
    private String password;

    @Value("${spring.datasource.dpp.driver-class-name}")
    private String driverClassName;

    @Primary
    @Bean(name = "dppDataSource")
    @Qualifier("dppDataSource")
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setAutoCommit(false);
        config.setJdbcUrl(dbUrl);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
    }
}
