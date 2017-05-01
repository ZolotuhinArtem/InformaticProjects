/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.config;

import com.zlthnrtm.hw9_article.repository.ArticlesRepository;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 *
 * @author arch
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.zlthnrtm.hw9_article.model"})
@EnableJpaRepositories(basePackages = {"com.zlthnrtm.hw9_article.repository"})
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
    
    
//    @Bean
//    public ArticlesRepository articlesRepository(){
//        return new ArticlesRepository(env.getProperty("table.articles.name"));
//    }
//    
//    @Bean
//    public SessionFactory setUp() throws Exception {
//        // A SessionFactory is set up once for an application!
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                        .configure() // configures settings from hibernate.cfg.xml
//                        .build();
//        try {
//            SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//            return sessionFactory;
//        }
//        catch (Exception ex) {
//                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//                // so destroy it manually.
//                
//                StandardServiceRegistryBuilder.destroy( registry );
//                Logger.getLogger(RootConfig.class.getName()).log(Level.SEVERE, null, ex);
//                
//                return null;
//        }
//        
//    }


    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
      LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
      entityManagerFactoryBean.setDataSource(dataSource());
      entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
      entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));
      //entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("com.zlthnrtm.hw9_article.model"));
      HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
      jpaVendorAdapter.setGenerateDdl(true);
      entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
      entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

      return entityManagerFactoryBean;
    }
    
     @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

    return transactionManager;
  }

  private Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
    properties.put("hibernate.enable_lazy_load_no_trans", env.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));

    return properties;
  }
    
}
