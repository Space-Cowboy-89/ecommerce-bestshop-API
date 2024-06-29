package com.codehero.bestshop.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.codehero.bestshop.db.repository",
        entityManagerFactoryRef = "prodEmFactory",
        transactionManagerRef = "prodDbTransManager")
@ComponentScan(basePackages = "com.codehero.bestshop.controller")
@EnableTransactionManagement
public class FirstConfig {

    @Bean(name="prodDbConn")
    @Autowired
    public DataSource getDbConnection(Environment env) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
        ds.setUrl(env.getRequiredProperty("spring.datasource.url"));
        ds.setUsername(env.getRequiredProperty("spring.datasource.username"));
        ds.setPassword(env.getRequiredProperty("spring.datasource.password"));
        return ds;
    }

    @Bean(name = "prodEmFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManager(DataSource ds) {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        //permette di aggiornare la struttura delle tabelle del db in base all'implementazioni delle classi entity
        adapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ds);
        factory.setJpaVendorAdapter(adapter);
        //Specifico il package dove sono contenute le classi Entity
        factory.setPackagesToScan("com.codehero.bestshop.db.entity");
        return factory;

    }


    @Bean(name = "prodDbTransManager")
    @Autowired
    public PlatformTransactionManager getTransactionManager(LocalContainerEntityManagerFactoryBean manager) {
        JpaTransactionManager jtm = new JpaTransactionManager(manager.getObject());
        return jtm;
    }

}





