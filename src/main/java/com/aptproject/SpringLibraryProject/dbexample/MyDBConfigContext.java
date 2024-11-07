package com.aptproject.SpringLibraryProject.dbexample;

import com.aptproject.SpringLibraryProject.dbexample.dao.BookDAOBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.aptproject.SpringLibraryProject.dbexample.constants.DBConstants.*;

@Configuration
//@ComponentScan
public class MyDBConfigContext {

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" +
                    DB, USER, PASSWORD);
        }

//    @Bean
//    public BookDAOBean bookDAOBean() throws SQLException {
//        return new BookDAOBean(getConnection());

    }

