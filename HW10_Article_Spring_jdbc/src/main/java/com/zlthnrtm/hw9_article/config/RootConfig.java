/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author arch
 */
@Configuration
@ComponentScan("com.zlthnrtm.hw9_article.repository")
@PropertySource("classpath:configuration/database.properties")
public class RootConfig {
    
    @Autowired
    private Environment env;
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("driver"));
        dataSource.setUsername(env.getProperty("name"));
        dataSource.setPassword(env.getProperty("password"));
        dataSource.setUrl(env.getProperty("url"));
        return dataSource;
    }
    
}
