package org.example;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConfig {

    @Bean(name="database")

    public DataSource getH2DataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ShoppingApp?userSSL=false&createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("password@123");

        System.out.println(" ---------- DataSource Object is Created ---------- ");

        return dataSource;
    }

    @Bean(name="sessionFactory")

    public SessionFactory getSessionFactory(){

        Properties hibernateProp = new Properties();

        hibernateProp.put("hibernate.hdm2ddl.auto","update");
        hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");

        LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(getH2DataSource());

        localFactory.addProperties(hibernateProp);


        System.out.println(" ---------- SessionFactory Object is Created ---------- ");

        return localFactory.buildSessionFactory();
    }

    @Bean(name="txtManager")

    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
        System.out.println(" ---------- Transaction Manager Object Created ---------- ");
        return new HibernateTransactionManager(sessionFactory);
    }
}
