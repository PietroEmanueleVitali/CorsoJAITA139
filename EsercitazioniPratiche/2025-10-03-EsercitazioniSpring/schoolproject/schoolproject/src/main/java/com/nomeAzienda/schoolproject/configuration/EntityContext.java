package com.nomeAzienda.schoolproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import com.nomeAzienda.schoolproject.database.Database;

//dove accumulare tutti i dati ottenuti dal database
//Questo deve essere un contenitore di oggetti, deve cercare qui dentro l'applicazione
public class EntityContext {

    //Cerca il singleton e se esiste lo piazza qui dentro
    @Autowired
    public Database database;
}
