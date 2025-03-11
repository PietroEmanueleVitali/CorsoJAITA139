package com.nomeAzienda.schoolproject.database;

import org.springframework.beans.factory.annotation.Value;
import java.sql.Connection;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.ToString;
@Service //Creerà dei singleton dove serve, non dobbiamo aggiungere altro
public class Database implements IDatabase {

    @Value("${spring.datasource.username}")
    private String username; //le definiamo dentro resource.application.properties
    
    @Value("${spring.datasource.password}")
    private String password;
    
    @Value("${spring.datasource.url}")
    private String url;

    private Connection connection;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    public Database(){}

    @Override
    public Long executeDML(String query, String... params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeDML'");
    }

    @Override
    public Map<Long, Map<String, String>> executeDQL(String query, String... params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeDQL'");
    }

}
