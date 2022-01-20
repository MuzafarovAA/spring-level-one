package ru.gb.lesson_11.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

@Configuration

public class AppConfig implements WebMvcConfigurer {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setUsername("root");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/lesson_11?autoReconnect=true&useSSL=false");
        config.setDriverClassName("com.mysql.jdbc.Driver");

        return new HikariDataSource(config);
    }

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dataSource());
    }
}