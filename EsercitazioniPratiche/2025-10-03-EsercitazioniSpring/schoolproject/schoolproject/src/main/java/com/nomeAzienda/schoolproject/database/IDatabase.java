package com.nomeAzienda.schoolproject.database;

import java.util.Map;

public interface IDatabase {
    Long executeDML(String query, String... params);
    Map<Long, Map<String, String>> executeDQL(String query, String... params);
}
